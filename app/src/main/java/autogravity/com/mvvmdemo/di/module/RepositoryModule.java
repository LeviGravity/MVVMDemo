package autogravity.com.mvvmdemo.di.module;

import autogravity.com.mvvmdemo.data.remote.repository.impl.UserListRepositoryImpl;
import autogravity.com.mvvmdemo.data.remote.service.RandomUserService;
import autogravity.com.mvvmdemo.domain.repository.UserListRepository;
import dagger.Module;
import dagger.Provides;

/**
 * Created by LeviHsiao on 4/10/18.
 */

@Module public class RepositoryModule {

    @Provides UserListRepository provideUserListRepository(RandomUserService service) {
        return new UserListRepositoryImpl(service);
        //return new UserListRepositoryImpl(service, userDao, scheduler);
    }
}
