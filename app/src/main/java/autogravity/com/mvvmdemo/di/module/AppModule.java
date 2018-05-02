package autogravity.com.mvvmdemo.di.module;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by LeviHsiao on 4/10/18.
 */

@Module public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides @Singleton Application providesApplication() {
        return this.application;
    }
}
