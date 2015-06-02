package tr.gov.tuik.spring.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;
import tr.gov.tuik.spring.domain.User;
import tr.gov.tuik.spring.service.UserService;
import tr.gov.tuik.spring.util.UserUtil;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Hasan on 1.6.2015.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserListControllerTest {

    @Mock
    private UserService userService;

    private UserListController userController;

    @Before
    public void setUp() throws Exception {
        userController = new UserListController(userService);
    }

    @Test
    public void shouldGetUserListPage() throws Exception {
        List<User> userList = stubServiceToReturnExistingUsers(5);
        ModelAndView view = userController.getListUsersView();
        // verify userService was called once
        verify(userService, times(1)).getList();
        assertEquals("View name should be right", "user_list", view.getViewName());
        assertEquals("Model should contain attribute with the list of users coming from the service",
                userList, view.getModel().get("users"));
    }

    private List<User> stubServiceToReturnExistingUsers(int howMany) {
        List<User> userList = UserUtil.createUserList(howMany);
        when(userService.getList()).thenReturn(userList);
        return userList;
    }
}
