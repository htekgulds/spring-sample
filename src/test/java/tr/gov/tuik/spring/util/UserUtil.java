package tr.gov.tuik.spring.util;

import tr.gov.tuik.spring.domain.User;

/**
 * Created by Hasan on 1.6.2015.
 */
public class UserUtil {

    private static final String ID = "id";
    private static final String PASSWORD = "password";

    private UserUtil() { }

    public static User createUser() {
        return new User(ID, PASSWORD);
    }
}
