package tr.gov.tuik.spring.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.Errors;
import tr.gov.tuik.spring.domain.UserCreateForm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Hasan TEKGÜL
 * on 6/2/2015
 */

@RunWith(MockitoJUnitRunner.class)
public class UserCreateFormPasswordValidatorTest {

    @Mock
    private Errors errors;

    private UserCreateFormPasswordValidator passwordValidator = new UserCreateFormPasswordValidator();

    @Test
    public void shouldSayItSupports_GivenItReceivesUserCreateFormClass() throws Exception {
        assertTrue(passwordValidator.supports(UserCreateForm.class));
    }

    @Test
    public void shouldSayItSupports_GivenItReceivesDifferentClass_ThenShouldReturnFalse() throws Exception {
        assertFalse(passwordValidator.supports(Object.class));
    }

    @Test
    public void shouldValidate_GivenPasswordsMatch_ThenErrorIsNotSet() throws Exception {
        UserCreateForm form = new UserCreateForm();
        form.setPassword1("password");
        form.setPassword2("password");
        passwordValidator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    public void shouldValidate_GivenPasswordsDoNotMatch_ThenErrorIsSet() throws Exception {
        UserCreateForm form = new UserCreateForm();
        form.setPassword1("password");
        form.setPassword2("different");
        passwordValidator.validate(form, errors);
        verify(errors).rejectValue("password2", "user.error.password.no_match") ;
    }
}
