package autogravity.com.mvvmdemo.di.module;

import autogravity.com.mvvmdemo.data.remote.service.RandomUserService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;

/**
 * Created by LeviHsiao on 4/10/18.
 */

@Module public class ServiceModule {

    @Provides @Singleton RandomUserService provideRandomUserService(Retrofit retrofit) {
        return retrofit.create(RandomUserService.class);
    }
}
