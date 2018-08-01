package autogravity.com.mvvmdemo.di.module

import autogravity.com.mvvmdemo.data.remote.repository.impl.UserListRepositoryImpl
import autogravity.com.mvvmdemo.data.remote.service.RandomUserService
import autogravity.com.mvvmdemo.domain.repository.UserListRepository
import dagger.Module
import dagger.Provides

/**
 * Created by LeviHsiao on 4/10/18.
 */

@Module class RepositoryModule {

    @Provides internal fun provideUserListRepository(service: RandomUserService): UserListRepository {
        return UserListRepositoryImpl(service)
        //return new UserListRepositoryImpl(service, userDao, scheduler);
    }
}
