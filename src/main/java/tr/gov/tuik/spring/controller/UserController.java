package tr.gov.tuik.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.spring.domain.User;
import tr.gov.tuik.spring.service.UserService;
import tr.gov.tuik.spring.service.exception.UserAlreadyExistsException;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by Hasan on 1.6.2015.
 */

@RestController
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User createUser(@RequestBody @Valid final User user) {
        return userService.save(user);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return e.getMessage();
    }
}
