package net.valiantwolf.essex.interceptors;

import androidx.annotation.NonNull;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

public class NoopInterceptor implements Interceptor {

  @NonNull
  @Override
  public Response intercept(@NonNull Chain chain) throws IOException {
    return chain.proceed(chain.request());
  }
}
