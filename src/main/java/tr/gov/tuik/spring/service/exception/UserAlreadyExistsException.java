package tr.gov.tuik.spring.service.exception;

/**
 * Created by Hasan on 1.6.2015.
 */
public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(final String message) {
        super(message);
    }
}
