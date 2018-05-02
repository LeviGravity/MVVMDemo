package autogravity.com.mvvmdemo.di.component;

import autogravity.com.mvvmdemo.di.module.AppModule;
import autogravity.com.mvvmdemo.di.module.NetworkModule;
import autogravity.com.mvvmdemo.di.module.RepositoryModule;
import autogravity.com.mvvmdemo.di.module.ServiceModule;
import autogravity.com.mvvmdemo.di.module.ViewModelModule;
import autogravity.com.mvvmdemo.presentation.userlist.UserListActivity;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by LeviHsiao on 4/10/18.
 */

@Singleton @Component(modules = {
    AppModule.class, NetworkModule.class, ServiceModule.class, RepositoryModule.class,
    ViewModelModule.class
}) public interface MainComponent {
    void inject(UserListActivity activity);
}
