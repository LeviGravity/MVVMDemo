package autogravity.com.mvvmdemo.di.module;

import android.app.Application;
import autogravity.com.mvvmdemo.data.remote.service.ApiConstants;
import autogravity.com.mvvmdemo.domain.schedulers.BaseSchedulerProvider;
import autogravity.com.mvvmdemo.domain.schedulers.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LeviHsiao on 4/10/18.
 */

@Module public class NetworkModule {

    private static final int CONNECT_TIMEOUT_IN_MS = 30000;

    @Provides @Singleton Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides @Singleton OkHttpClient provideOkHttpClient(Cache cache) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new okhttp3.OkHttpClient.Builder().connectTimeout(CONNECT_TIMEOUT_IN_MS,
            TimeUnit.MILLISECONDS).addInterceptor(loggingInterceptor).build();
        //return new OkHttpClient().newBuilder().build();
    }

    @Singleton @Provides Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl(ApiConstants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    }

    @Singleton @Provides SchedulerProvider provideSchedulerProvider() {
        return new SchedulerProvider();
    }

    @Singleton @Provides BaseSchedulerProvider provideBaseSchedulerProvider() {
        return new SchedulerProvider();
    }
}
