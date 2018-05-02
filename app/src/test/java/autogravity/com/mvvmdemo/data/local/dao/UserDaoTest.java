package autogravity.com.mvvmdemo.data.local.dao;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import autogravity.com.mvvmdemo.data.local.UserDatabase;
import autogravity.com.mvvmdemo.data.local.entity.SavedUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class) public class UserDaoTest {

    @Rule public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private static final SavedUser SAVED_USER = new SavedUser("Android", "Fan");
    private UserDatabase userDatabase;

    @Before public void setUp() throws Exception {
        userDatabase =
            Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), UserDatabase.class)
                .allowMainThreadQueries()
                .build();
    }

    @After public void tearDown() throws Exception {
        userDatabase.close();
    }

    @Test public void getUsersWhenNoUserInserted() {
        userDatabase.getUserDao().getAllSavedUsers().test().assertNoValues();
    }

    @Test public void getAllSavedUsers() {
    }

    @Test public void getUserById() {
    }

    @Test public void insertAll() {
    }

    @Test public void update() {
    }

    @Test public void delete() {
    }
}