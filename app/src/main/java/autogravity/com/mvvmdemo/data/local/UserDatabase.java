package autogravity.com.mvvmdemo.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import autogravity.com.mvvmdemo.data.local.dao.UserDao;
import autogravity.com.mvvmdemo.data.local.entity.SavedUser;

@Database(entities = { SavedUser.class }, version = 1) public abstract class UserDatabase
    extends RoomDatabase {
    public abstract UserDao getUserDao();
}
