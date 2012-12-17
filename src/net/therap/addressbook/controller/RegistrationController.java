package net.therap.addressbook.controller;

import net.therap.addressbook.domain.User;
import net.therap.addressbook.service.UserService;
import net.therap.addressbook.service.UserServiceImpl;
import net.therap.addressbook.service.ValidationService;
import net.therap.addressbook.service.ValidationServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * User: anjum
 * Date: 11/13/12
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {
    UserService userService;
    private MessageSource messageSource;

    RegistrationController() {
        userService = new UserServiceImpl();
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String loadLoginForm(Model model) {
        model.addAttribute("newUser", new User());
        return "/registrationForm";
    }

    @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
    public String addNewUser(@RequestParam(value = "confPassword", required = true) String confPassword, User user, Model model) {
        ValidationService validationService = new ValidationServiceImpl();
        boolean validated = true;
        try {
            validated = validationService.validateFormFields(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if (validated) {
            if (user.getPassword().equals(confPassword)) {
                model.addAttribute("registrationSuccessMessage", "You have been registered successfully");
                userService.saveUser(user);
                return "/registrationForm";

            } else {
                model.addAttribute("passwordMismatch","Password not Matched");
                return "/registrationForm";
            }
        } else {
                return "/registrationForm";
        }
    }
}
