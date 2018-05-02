package autogravity.com.mvvmdemo.data.remote.repository.impl;

import autogravity.com.mvvmdemo.data.remote.service.RandomUserService;
import autogravity.com.mvvmdemo.domain.repository.UserListRepository;
import com.domain.model.User;
import com.domain.model.UserResponse;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by LeviHsiao on 4/10/18.
 */

@Singleton public class UserListRepositoryImpl implements UserListRepository {

    private final RandomUserService randomUserService;
    //private final UserDao userDao;
    //private final BaseSchedulerProvider scheduler;

    @Inject public UserListRepositoryImpl(RandomUserService randomUserService) {
        this.randomUserService = randomUserService;
        //this.userDao = userDao;
        //this.scheduler = scheduler;
    }

    @Override public Observable<List<User>> getUsers(int count, String seed, int page) {
        return randomUserService.getUserResponse(count, seed, page).map(UserResponse::getResults);
        //return Observable.concatArray(getUsersFromService(count, seed))
    }

    //private Observable<List<User>> getUsersFromService(int count, String seed) {
    //    return randomUserService.getUserResponse(count, seed)
    //        .map(UserResponse::getResults)
    //        .doOnNext(this::storeUsersInDb);
    //}

    //private Observable<List<User>> getusersFromDb(){
    //    return userDao.getAllSavedUsers().filter(new Predicate<List<SavedUser>>() {
    //        @Override public boolean test(List<SavedUser> savedUsers) throws Exception {
    //            return !savedUsers.isEmpty();
    //        }
    //    }).toObservable();
    //}

    //private void storeUsersInDb(List<User> users) {
    //    Observable.fromCallable(() -> userDao.insertAll(users))
    //        .subscribeOn(scheduler.io())
    //        .observeOn(scheduler.io())
    //        .subscribe();
    //}
}
