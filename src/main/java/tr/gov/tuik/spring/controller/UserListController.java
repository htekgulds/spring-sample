package tr.gov.tuik.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tr.gov.tuik.spring.domain.User;
import tr.gov.tuik.spring.service.UserService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Hasan on 1.6.2015.
 */

@Controller
public class UserListController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserListController.class);
    private final UserService userService;

    @Inject
    public UserListController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user_list.html")
    public ModelAndView getListUsersView() {
        LOGGER.debug("Received request to get user list view");
        ModelMap model = new ModelMap();
        model.addAttribute("users", userService.getList());
        return new ModelAndView("user_list", model);
    }
}
