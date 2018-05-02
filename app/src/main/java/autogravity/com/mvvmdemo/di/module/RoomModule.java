package autogravity.com.mvvmdemo.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import autogravity.com.mvvmdemo.data.local.UserDatabase;
import autogravity.com.mvvmdemo.data.local.dao.UserDao;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class RoomModule {

    @Singleton @Provides UserDatabase providesUserDatabase(Application application) {
        return Room.databaseBuilder(application, UserDatabase.class, "user-db").build();
    }

    @Singleton @Provides UserDao providesUserDao(UserDatabase userDatabase){
        return userDatabase.getUserDao();
    }
}
