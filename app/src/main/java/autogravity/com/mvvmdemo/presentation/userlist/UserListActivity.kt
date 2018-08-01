package autogravity.com.mvvmdemo.presentation.userlist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import autogravity.com.mvvmdemo.R
import autogravity.com.mvvmdemo.data.remote.service.ApiConstants
import autogravity.com.mvvmdemo.domain.Response
import autogravity.com.mvvmdemo.domain.Status
import autogravity.com.mvvmdemo.presentation.common.BaseActivity
import autogravity.com.mvvmdemo.util.DividerItemDecoration
import autogravity.com.mvvmdemo.util.EndlessScrollListener
import com.domain.model.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

/**
 * Created by LeviHsiao on 4/10/18.
 */
class UserListActivity : BaseActivity() {

    @Inject lateinit var factory: ViewModelProvider.Factory
    private var userListViewModel: UserListViewModel? = null
    private var adapter: UserListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainComponent?.inject(this)

        setupUi()

        initViewModel()
    }

    private fun setupUi() {
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = linearLayoutManager
        recyclerview.setHasFixedSize(true)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST)
        recyclerview.addItemDecoration(itemDecoration)

        val scrollListener = object : EndlessScrollListener(linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                fetchData(page)
            }
        }
        recyclerview.addOnScrollListener(scrollListener)

        adapter = UserListAdapter(this)
        recyclerview.adapter = adapter
    }

    private fun initViewModel() {
        userListViewModel = ViewModelProviders.of(this, factory).get(UserListViewModel::class.java)
        fetchData(ApiConstants.API_PARAM_PAGE_DEFAULT)
        userListViewModel!!.userListResponse.observe(this, responseObserver)
    }

    private val responseObserver = Observer<Response<List<User>>> { response ->
        response?.let { processResponse(response) }
    }

    private fun fetchData(page: Int) {
        userListViewModel!!.fetchUsers(ApiConstants.API_PARAM_RESULTS_DEFAULT,
            ApiConstants.API_PARAM_SEED_DEFAULT, page)
    }

    private fun processResponse(response: Response<List<User>>) {
        when (response.status) {
            Status.LOADING -> renderLoadingState()
            Status.SUCCESS -> renderDataState(response.data)
            Status.ERROR -> renderErrorState(response.throwable)
        }
    }

    private fun renderLoadingState() {
        // Start progress bar
    }

    private fun renderDataState(userList: List<User>?) {
        populateList(userList)
    }

    private fun renderErrorState(t: Throwable?) {
        showError(t!!)
    }

    private fun populateList(users: List<User>?) {
        adapter!!.addUsers(users)
    }

    private fun showError(t: Throwable) {
        Log.d("Levi, message", t.message)
        Log.d("Levi, localized message", t.localizedMessage)
        when (t) {
            is HttpException -> {
                Log.d("levi", "HTTP Exception")
                val responseBody = t.response().errorBody()
                Log.d("levi", "HTTP Exception MSG: " + responseBody.toString())
            }
            is SocketTimeoutException -> Log.d("levi", "SocketTimeoutException")
            is IOException -> Log.d("levi", "IOException")
            else -> Log.d("levi", "Unknown Error")
        }
    }
}
