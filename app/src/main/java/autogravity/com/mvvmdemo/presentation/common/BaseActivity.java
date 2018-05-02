package autogravity.com.mvvmdemo.presentation.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import autogravity.com.mvvmdemo.di.component.MainComponent;
import autogravity.com.mvvmdemo.presentation.MvvmApp;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    @Override public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    private MvvmApp getMvvmApp() {
        return (MvvmApp) getApplication();
    }

    protected MainComponent getMainComponent() {
        return getMvvmApp().getMainComponent();
    }

    protected abstract int getLayoutId();
}
