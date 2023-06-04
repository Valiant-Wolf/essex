package net.valiantwolf.essex;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import java.io.IOException;
import net.valiantwolf.essex.entity.Post;

import net.valiantwolf.essex.interceptors.NoopInterceptor;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.internal.impl.PowerMockJUnit49RunnerDelegateImpl;

public class RestClientTest {

  @Test
  public void getPosts() {
    RestClient classUnderTest = new RestClient(new NoopInterceptor());

    List<Post> posts = classUnderTest.getPosts();
    assertNotNull(posts);
  }
}