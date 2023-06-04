package net.valiantwolf.essex.interceptors;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Blocks requests to ensure a minimum delay is not exceeded
 */
public class RateLimitingInterceptor implements Interceptor {

  private volatile long last = 0;
  private final int minDelay;

  public RateLimitingInterceptor( int minimumDelayMillis )
  {
    minDelay = minimumDelayMillis;
  }

  @NonNull
  @Override
  public Response intercept(@NonNull Chain chain) throws IOException {
    long difference = (last + minDelay) - SystemClock.uptimeMillis();
    if (difference > 0) {
      SystemClock.sleep(difference);
    }

    last = SystemClock.uptimeMillis();

    Response response = chain.proceed( chain.request() );

    //TODO: add proper handling for 429 responses

    return response;
  }
}
