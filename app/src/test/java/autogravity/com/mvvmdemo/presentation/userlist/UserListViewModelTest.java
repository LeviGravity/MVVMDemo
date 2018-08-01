package autogravity.com.mvvmdemo.presentation.userlist;

import autogravity.com.mvvmdemo.domain.repository.UserListRepository;
import autogravity.com.mvvmdemo.domain.schedulers.BaseSchedulerProvider;
import autogravity.com.mvvmdemo.domain.schedulers.ImmediateSchedulerProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class) public class UserListViewModelTest {

    @Mock private BaseSchedulerProvider schedulerProvider;
    @Mock private UserListRepository repository;

    private UserListViewModel userListViewModel;

    @Before public void setUp() {
        MockitoAnnotations.initMocks(this);
        schedulerProvider = new ImmediateSchedulerProvider();
        userListViewModel = new UserListViewModel(schedulerProvider, repository);
    }

    @Test public void testFetchUsers() throws Exception {

    }
}