package autogravity.com.mvvmdemo.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import autogravity.com.mvvmdemo.presentation.common.ViewModelFactory;
import autogravity.com.mvvmdemo.presentation.userlist.UserListViewModel;
import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import dagger.multibindings.IntoMap;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by LeviHsiao on 4/10/18.
 */

@Module public abstract class ViewModelModule {

    @Binds @IntoMap @ViewModelKey(UserListViewModel.class)
    public abstract ViewModel bindUserListViewModel(UserListViewModel userListViewModel);

    @Binds public abstract ViewModelProvider.Factory bindViewModelFactory(
        ViewModelFactory viewModelFactory);

    @Documented @Target({ ElementType.METHOD }) @Retention(RetentionPolicy.RUNTIME) @MapKey
    @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }
}
