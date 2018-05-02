package autogravity.com.mvvmdemo.domain.schedulers;

import android.support.annotation.NonNull;
import io.reactivex.Scheduler;

/**
 * Created by LeviHsiao on 4/10/18.
 */

public interface BaseSchedulerProvider {

    @NonNull Scheduler computation();

    @NonNull Scheduler io();

    @NonNull Scheduler mainThread();

    @NonNull Scheduler newThread();
}
