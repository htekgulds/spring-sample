package tr.gov.tuik.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tr.gov.tuik.spring.domain.UserCreateForm;

/**
 * Created by Hasan TEKGÜL
 * on 6/2/2015
 */

@Component
public class UserCreateFormPasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserCreateForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;
        if (!form.getPassword1().equals(form.getPassword2())) {
            errors.rejectValue("password2", "user.error.password.no_match");
        }
    }
}
