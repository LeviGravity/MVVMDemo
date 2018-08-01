package autogravity.com.mvvmdemo.domain.schedulers

import io.reactivex.Scheduler

/**
 * Created by LeviHsiao on 4/10/18.
 */

interface BaseSchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun mainThread(): Scheduler

    fun newThread(): Scheduler
}
