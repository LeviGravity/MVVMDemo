package autogravity.com.mvvmdemo.presentation.userlist;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import javax.inject.Inject;

/**
 * Created by LeviHsiao on 4/10/18.
 */
public class UserListViewModelFactory implements ViewModelProvider.Factory {

    private UserListViewModel userListViewModel;

    @Inject public UserListViewModelFactory(UserListViewModel userListViewModel) {
        this.userListViewModel = userListViewModel;
    }

    @NonNull @Override public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(UserListViewModel.class)) {
            return (T) userListViewModel;
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
