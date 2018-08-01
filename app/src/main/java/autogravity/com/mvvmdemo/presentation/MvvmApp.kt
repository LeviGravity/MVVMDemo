package autogravity.com.mvvmdemo.presentation

import android.app.Application
import autogravity.com.mvvmdemo.di.component.DaggerMainComponent
import autogravity.com.mvvmdemo.di.component.MainComponent
import autogravity.com.mvvmdemo.di.module.AppModule

/**
 * Created by LeviHsiao on 4/10/18.
 */

class MvvmApp : Application() {

    var mainComponent: MainComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        mainComponent = DaggerMainComponent.builder().appModule(AppModule(this)).build()
    }
}
