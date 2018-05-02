package autogravity.com.mvvmdemo.data.remote.service;

import com.domain.model.UserResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by LeviHsiao on 4/10/18.
 */

public interface RandomUserService {
    @GET("api") Observable<UserResponse> getUserResponse(
        @Query(ApiConstants.API_QUERY_RESULTS) int number,
        @Query(ApiConstants.API_QUERY_SEED) String seed,
        @Query(ApiConstants.API_QUERY_PAGE) int page);
}
