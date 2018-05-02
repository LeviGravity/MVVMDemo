package autogravity.com.mvvmdemo.presentation.userlist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import autogravity.com.mvvmdemo.domain.repository.UserListRepository;
import autogravity.com.mvvmdemo.domain.schedulers.BaseSchedulerProvider;
import com.domain.model.User;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by LeviHsiao on 4/10/18.
 */

public class UserListViewModel extends ViewModel {

    private final CompositeDisposable disposables = new CompositeDisposable();
    private final BaseSchedulerProvider scheduler;
    private final UserListRepository repository;
    private MutableLiveData<List<User>> userListObservable = new MutableLiveData<>();
    private MutableLiveData<Throwable> error = new MutableLiveData<>();

    @Inject
    public UserListViewModel(BaseSchedulerProvider scheduler, UserListRepository repository) {
        this.scheduler = scheduler;
        this.repository = repository;
    }

    public void fetchUsers(int count, String seed, int page) {
        disposables.add(repository.getUsers(count, seed, page)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.mainThread())
            .subscribe(userListObservable::setValue, error::setValue));
    }

    public LiveData<List<User>> getUserListObservable() {
        return userListObservable;
    }

    public LiveData<Throwable> getError() {
        return error;
    }

    @Override protected void onCleared() {
        disposables.clear();
    }
}
