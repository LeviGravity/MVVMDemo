package autogravity.com.mvvmdemo.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import autogravity.com.mvvmdemo.presentation.userlist.UserListViewModel;
import autogravity.com.mvvmdemo.presentation.userlist.UserListViewModelFactory;
import dagger.Module;
import dagger.Provides;

/**
 * Created by LeviHsiao on 4/10/18.
 */

@Module public class ViewModelModule {

    @Provides ViewModel providesUserListViewModel(UserListViewModel userListViewModel) {
        return userListViewModel;
    }

    @Provides ViewModelProvider.Factory providesViewModelFactory(UserListViewModelFactory factory) {
        return factory;
    }
}
