package autogravity.com.mvvmdemo.domain.schedulers;

import android.support.annotation.NonNull;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by LeviHsiao on 4/10/18.
 */

public class ImmediateSchedulerProvider implements BaseSchedulerProvider {

    @NonNull @Override public Scheduler computation() {
        return Schedulers.trampoline();
    }

    @NonNull @Override public Scheduler io() {
        return Schedulers.trampoline();
    }

    @NonNull @Override public Scheduler mainThread() {
        return Schedulers.trampoline();
    }

    @NonNull @Override public Scheduler newThread() {
        return Schedulers.trampoline();
    }
}
