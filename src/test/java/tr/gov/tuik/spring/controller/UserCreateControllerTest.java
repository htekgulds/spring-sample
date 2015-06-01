package tr.gov.tuik.spring.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;
import tr.gov.tuik.spring.domain.UserCreateForm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hasan on 1.6.2015.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserCreateControllerTest {

    private UserCreateController userController;

    @Before
    public void setUp() throws Exception {
        userController = new UserCreateController();
    }

    @Test
    public void shouldGetCreateUserPage() throws Exception {
        ModelAndView view = userController.getCreateUserView();
        assertEquals("View should be right", "user_create", view.getViewName());
        assertTrue("View should contain attribute with form object", view.getModel().containsKey("form"));
        assertTrue("The form object should be of proper type", view.getModel().get("form") instanceof UserCreateForm);
    }
}
