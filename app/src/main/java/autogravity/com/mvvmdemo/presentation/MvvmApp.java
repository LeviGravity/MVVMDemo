package autogravity.com.mvvmdemo.presentation;

import android.app.Application;
import autogravity.com.mvvmdemo.di.component.DaggerMainComponent;
import autogravity.com.mvvmdemo.di.component.MainComponent;
import autogravity.com.mvvmdemo.di.module.AppModule;

/**
 * Created by LeviHsiao on 4/10/18.
 */

public class MvvmApp extends Application {

    private MainComponent mainComponent;

    @Override public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        mainComponent = DaggerMainComponent.builder().appModule(new AppModule(this)).build();
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }
}
