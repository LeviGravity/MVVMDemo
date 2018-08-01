package autogravity.com.mvvmdemo.di.component

import autogravity.com.mvvmdemo.di.module.*
import autogravity.com.mvvmdemo.presentation.userlist.UserListActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by LeviHsiao on 4/10/18.
 */

@Singleton
@Component(modules = [(AppModule::class), (NetworkModule::class), (ServiceModule::class), (RepositoryModule::class), (ViewModelModule::class)])
interface MainComponent {
    fun inject(activity: UserListActivity)
}
