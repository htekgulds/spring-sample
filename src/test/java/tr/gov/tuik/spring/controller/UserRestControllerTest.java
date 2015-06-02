package tr.gov.tuik.spring.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tr.gov.tuik.spring.domain.User;
import tr.gov.tuik.spring.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Hasan TEKGÜL
 * on 6/1/2015
 */

@RunWith(MockitoJUnitRunner.class)
public class UserRestControllerTest {

    @Mock
    private UserService userService;

    private UserRestController userRestController;

    @Before
    public void setUp() {
        userRestController = new UserRestController(userService);
    }

    @Test
    public void shouldCreateUser() throws Exception {
        final User savedUser = stubServiceToReturnStoredUser();
        final User user = new User();
        User returnedUser = userRestController.createUser(user);
        // verify user was passed to UserService
        verify(userService, times(1)).save(user);
        assertEquals("Returned user should come from the service", savedUser, returnedUser);
    }

    private User stubServiceToReturnStoredUser() {
        final User user = new User();
        when(userService.save(any(User.class))).thenReturn(user);
        return user;
    }
}
