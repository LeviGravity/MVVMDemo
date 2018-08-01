package autogravity.com.mvvmdemo.domain.repository

import com.domain.model.User
import io.reactivex.Observable

/**
 * Created by LeviHsiao on 4/10/18.
 */

interface UserListRepository {
    fun getUsers(count: Int, seed: String, page: Int): Observable<List<User>>
}
