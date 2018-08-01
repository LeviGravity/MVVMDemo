package autogravity.com.mvvmdemo.di.module

import autogravity.com.mvvmdemo.data.remote.service.RandomUserService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by LeviHsiao on 4/10/18.
 */

@Module class ServiceModule {

    @Provides @Singleton internal fun provideRandomUserService(retrofit: Retrofit): RandomUserService {
        return retrofit.create(RandomUserService::class.java)
    }
}
