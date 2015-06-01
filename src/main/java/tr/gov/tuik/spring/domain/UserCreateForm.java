package tr.gov.tuik.spring.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Hasan on 1.6.2015.
 */
public class UserCreateForm {

    @NotEmpty
    @Size(max = 64)
    private String id;

    @NotEmpty
    @Size(max = 64)
    private String password1;
    private String password2;

    public UserCreateForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
