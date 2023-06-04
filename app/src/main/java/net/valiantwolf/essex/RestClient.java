package net.valiantwolf.essex;

import static java.util.Objects.requireNonNull;

import android.app.ActivityManager.RunningServiceInfo;
import com.google.gson.Gson;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.Moshi;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import net.valiantwolf.essex.entity.Post;
import net.valiantwolf.essex.entity.PostResults;

import java.io.IOException;
import java.util.List;

import net.valiantwolf.essex.interceptors.RateLimitingInterceptor;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class RestClient {

  private static final String USERNAME = BuildConfig.apiUser;
  private static final String KEY = BuildConfig.apiKey;
  private static final String USER_AGENT = "Essex/0.1 (by Valiant Wolf on e621)";
  private static final int MINIMUM_DELAY = 1000;
  private static final String ROOT = "https://e621.net";

  private final OkHttpClient client;
  private final Gson gson = new Gson();

  private final Moshi moshi = new Moshi.Builder().build();
  private final JsonAdapter<PostResults> postAdapter = moshi.adapter(PostResults.class);

  public RestClient() {
    this(new RateLimitingInterceptor(MINIMUM_DELAY));
  }

  protected RestClient(Interceptor rateLimitingInterceptor) {
    client = new OkHttpClient.Builder().authenticator((route, response) -> {
                                         String credential = Credentials.basic(USERNAME, KEY);
                                         return response.request()
                                                        .newBuilder()
                                                        .header("Authorization", credential)
                                                        .build();
                                       })
                                       .addInterceptor(rateLimitingInterceptor)
                                       .build();
  }

  private Request.Builder requestBuilder() {
    return new Request.Builder().header("User-Agent", USER_AGENT);
  }

  private <T> CompletableFuture<T> getAsync(String url, JsonAdapter<T> adapter) {
    Request request = requestBuilder().url(url)
                                      .get()
                                      .build();

    ResponseFutureCallback callback = new ResponseFutureCallback();
    client.newCall(request).enqueue(callback);

    return callback.getFuture().thenApply( o -> {
      try ( ResponseBody body = o.body()) {
        //noinspection ConstantConditions
        return adapter.fromJson(body.source());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
  }

  public List<Post> getPosts() {
    return getPostsAsync().join();
  }

  public CompletableFuture<List<Post>> getPostsAsync() {
    return getAsync(ROOT + "/posts.json", postAdapter).thenApply(PostResults::getPosts);
  }
}
