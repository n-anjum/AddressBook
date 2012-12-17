package net.therap.addressbook.controller;

import net.therap.addressbook.domain.Contact;
import net.therap.addressbook.domain.User;
import net.therap.addressbook.service.ContactListService;
import net.therap.addressbook.service.ContactListServiceImpl;
import net.therap.addressbook.service.UserService;
import net.therap.addressbook.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anjum
 * Date: 11/13/12
 * Time: 6:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/user")
//@SessionAttributes("user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    UserService userService;
    ContactListService contactListService;

    UserController() {
        userService = new UserServiceImpl();
        contactListService = new ContactListServiceImpl();
    }

    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public String loadLogInForm(Model model) {
        model.addAttribute("user", new User());
        return "/loginForm";
    }

    @RequestMapping(value = "/loginValidation", method = RequestMethod.POST)
    public String VarifyLogInUser(User user, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User verifiedUser = userService.verifyUser(user);
        if (verifiedUser != null) {
            session.setAttribute("loggedInUser", verifiedUser);
            return "redirect:/user/listOfContact";
        } else {
            model.addAttribute("invalidUser", "You are not an Authenticated User");
            return "/loginForm";
        }
    }

    @RequestMapping(value = "/listOfContact", method = RequestMethod.GET)
    public String ShowContactList(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            log.debug(loggedInUser.getName() + " " + loggedInUser.getId() + "  is a authenticated User");
            List<Contact> listOfContact = contactListService.getAllContact(loggedInUser);
            session.setAttribute("contactList", listOfContact);
        }
        return "/listOfContact";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOutUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/homepage";
    }

}
