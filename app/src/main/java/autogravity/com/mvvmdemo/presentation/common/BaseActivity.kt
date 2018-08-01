package autogravity.com.mvvmdemo.presentation.common

import android.support.v7.app.AppCompatActivity
import autogravity.com.mvvmdemo.di.component.MainComponent
import autogravity.com.mvvmdemo.presentation.MvvmApp

abstract class BaseActivity : AppCompatActivity() {

    private val mvvmApp: MvvmApp
        get() = application as MvvmApp

    protected val mainComponent: MainComponent?
        get() = mvvmApp.mainComponent
}
