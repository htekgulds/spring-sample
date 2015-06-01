package tr.gov.tuik.spring.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tr.gov.tuik.spring.domain.User;
import tr.gov.tuik.spring.repository.UserRepository;
import tr.gov.tuik.spring.service.exception.UserAlreadyExistsException;
import tr.gov.tuik.spring.service.impl.UserServiceImpl;
import tr.gov.tuik.spring.util.UserUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Hasan on 1.6.2015.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void shouldSaveNewUser_GivenThereDoesNotExistOneWithTheSameId_ThenTheSavedUserShouldBeReturned() {
        final User savedUser = stubRepositoryToReturnUserOnSave();
        final User user = UserUtil.createUser();
        final User returnedUser = userService.save(user);
        // verify repository was called with user
        verify(userRepository, times(1)).save(user);
        assertEquals("Returned user should come from the repository", savedUser, returnedUser);
    }

    private User stubRepositoryToReturnUserOnSave() {
        User user = UserUtil.createUser();
        when(userRepository.save(any(User.class))).thenReturn(user);
        return user;
    }

    public void shouldSaveNewUser_GivenThereExistsOneWithTheSameId_ThenTheExceptionShouldBeThrown() throws Exception {
        stubRepositoryToReturnExistingUser();
        try {
            userService.save(UserUtil.createUser());
            fail("Expected exception");
        }
        catch (UserAlreadyExistsException ignored) { }

        verify(userRepository, never()).save(any(User.class));
    }

    private void stubRepositoryToReturnExistingUser() {
        final User user = UserUtil.createUser();
        when(userRepository.findOne(user.getId())).thenReturn(user);
    }
}
