package autogravity.com.mvvmdemo.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import autogravity.com.mvvmdemo.data.local.entity.SavedUser;
import io.reactivex.Flowable;
import java.util.List;

@Dao public interface UserDao {

    @Query("SELECT * FROM saveduser") Flowable<List<SavedUser>> getAllSavedUsers();

    @Query("SELECT * FROM saveduser WHERE uid = :uid") SavedUser getUserById(String uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE) void insertAll(List<SavedUser> savedUsers);

    @Update void update(SavedUser user);

    @Delete void delete(SavedUser user);
}
