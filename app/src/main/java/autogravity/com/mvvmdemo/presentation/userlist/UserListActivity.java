package autogravity.com.mvvmdemo.presentation.userlist;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import autogravity.com.mvvmdemo.R;
import autogravity.com.mvvmdemo.data.remote.service.ApiConstants;
import autogravity.com.mvvmdemo.presentation.common.BaseActivity;
import autogravity.com.mvvmdemo.util.DividerItemDecoration;
import autogravity.com.mvvmdemo.util.EndlessScrollListener;
import butterknife.BindView;
import com.domain.model.User;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by LeviHsiao on 4/10/18.
 */
public class UserListActivity extends BaseActivity {

    @Inject ViewModelProvider.Factory factory;
    private UserListViewModel userListViewModel;
    private UserListAdapter adapter;

    @BindView(R.id.recyclerview) RecyclerView recyclerView;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMainComponent().inject(this);

        setupUi();

        initViewModel();
    }

    @Override protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void setupUi() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration =
            new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        recyclerView.addItemDecoration(itemDecoration);

        EndlessScrollListener scrollListener = new EndlessScrollListener(linearLayoutManager) {
            @Override public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                fetchData(page);
            }
        };
        recyclerView.addOnScrollListener(scrollListener);

        adapter = new UserListAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    private void initViewModel() {
        userListViewModel = ViewModelProviders.of(this, factory).get(UserListViewModel.class);
        fetchData(ApiConstants.API_PARAM_PAGE_DEFAULT);
        observeResponse();
        observeError();
    }

    private void fetchData(int page) {
        userListViewModel.fetchUsers(ApiConstants.API_PARAM_RESULTS_DEFAULT,
            ApiConstants.API_PARAM_SEED_DEFAULT, page);
    }

    private void observeResponse() {
        userListViewModel.getUserListObservable().observe(this, this::populateList);
    }

    private void observeError() {
        userListViewModel.getError().observe(this, this::showError);
    }

    private void populateList(List<User> users) {
        adapter.addUsers(users);
    }

    private void showError(Throwable t) {
        Toast.makeText(this, t.toString(), Toast.LENGTH_LONG).show();
    }
}
