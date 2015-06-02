package tr.gov.tuik.spring.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import tr.gov.tuik.spring.domain.User;
import tr.gov.tuik.spring.domain.UserCreateForm;
import tr.gov.tuik.spring.service.UserService;
import tr.gov.tuik.spring.service.exception.UserAlreadyExistsException;
import tr.gov.tuik.spring.validator.UserCreateFormPasswordValidator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Hasan on 1.6.2015.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserCreateControllerTest {

    @Mock
    private UserService userService;
    @Mock
    private BindingResult result;
    @Mock
    private UserCreateFormPasswordValidator passwordValidator;

    private UserCreateController userController;

    @Before
    public void setUp() throws Exception {
        userController = new UserCreateController(userService, passwordValidator);
    }

    @Test
    public void shouldGetCreateUserPage() throws Exception {
        ModelAndView view = userController.getCreateUserView();
        assertEquals("View should be right", "user_create", view.getViewName());
        assertTrue("View should contain attribute with form object", view.getModel().containsKey("form"));
        assertTrue("The form object should be of proper type", view.getModel().get("form") instanceof UserCreateForm);
    }

    @Test
    public void shouldCreateUser_GivenThereAreNoErrors_ThenTheUserShouldBeSavedAndUserListViewDisplayed() {
        when(result.hasErrors()).thenReturn(false);
        UserCreateForm form = new UserCreateForm();
        form.setId("id");
        form.setPassword1("password");
        form.setPassword2("password");
        String view = userController.createUser(form, result);
        assertEquals("There should be proper redirect", "redirect:/user_list.html", view);
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(userService, times(1)).save(captor.capture());
        assertEquals(form.getId(), captor.getValue().getId());
        assertEquals(form.getPassword1(), captor.getValue().getPassword());
    }

    @Test
    public void shouldCreateUser_GivenThereAreFormErrors_ThenTheFormShouldBeDisplayed() {
        when(result.hasErrors()).thenReturn(false);
        when(userService.save(any(User.class))).thenThrow(UserAlreadyExistsException.class);
        String view = userController.createUser(new UserCreateForm(), result);
        verify(result).reject("user.error.exists");
        assertEquals("View name should be right", "user_create", view);
    }
}
