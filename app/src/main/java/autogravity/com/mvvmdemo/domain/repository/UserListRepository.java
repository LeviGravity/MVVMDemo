package autogravity.com.mvvmdemo.domain.repository;

import com.domain.model.User;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by LeviHsiao on 4/10/18.
 */

public interface UserListRepository {

    Observable<List<User>> getUsers(int count, String seed, int page);
}
