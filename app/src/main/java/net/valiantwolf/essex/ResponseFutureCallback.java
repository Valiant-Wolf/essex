package net.valiantwolf.essex;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Wraps an OkHttp Callback in a CompletableFuture
 */
public class ResponseFutureCallback implements Callback {
  private final CompletableFuture<Response> future = new CompletableFuture<>();

  public CompletableFuture<Response> getFuture() {
    return future;
  }

  @Override
  public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
    future.complete(response);
  }

  @Override
  public void onFailure(@NonNull Call call, @NonNull IOException e) {
    future.completeExceptionally(e);
  }
}
