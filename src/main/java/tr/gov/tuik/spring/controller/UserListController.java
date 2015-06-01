package tr.gov.tuik.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import tr.gov.tuik.spring.domain.User;
import tr.gov.tuik.spring.service.UserService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Hasan on 1.6.2015.
 */

@Controller
public class UserListController {

    private final UserService userService;

    @Inject
    public UserListController(final UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("users")
    List<User> getUserList() {
        return userService.getList();
    }

    @RequestMapping("/user_list.html")
    public String getListUsersView() {
        return "user_list";
    }
}
