package autogravity.com.mvvmdemo.presentation.userlist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import autogravity.com.mvvmdemo.domain.Response
import autogravity.com.mvvmdemo.domain.repository.UserListRepository
import autogravity.com.mvvmdemo.domain.schedulers.BaseSchedulerProvider
import com.domain.model.User
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by LeviHsiao on 4/10/18.
 */

class UserListViewModel @Inject
constructor(private val scheduler: BaseSchedulerProvider, private val repository: UserListRepository) : ViewModel() {

    private val disposables = CompositeDisposable()
    private val userListLiveData = MutableLiveData<Response<List<User>>>()

    val userListResponse: LiveData<Response<List<User>>>
        get() = userListLiveData

    fun fetchUsers(count: Int, seed: String, page: Int) {
        userListLiveData.value = Response.loading()
        disposables.add(repository.getUsers(count, seed, page)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.mainThread())
            .subscribe(::setUserListResponse, ::setError))
    }

    private fun setUserListResponse(userList: List<User>) {
        userListLiveData.value = Response.success(userList)
    }

    private fun setError(t: Throwable) {
        userListLiveData.value = Response.error(t, null)
    }

    override fun onCleared() {
        disposables.clear()
    }
}
