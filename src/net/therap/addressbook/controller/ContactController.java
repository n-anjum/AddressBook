package net.therap.addressbook.controller;

import net.therap.addressbook.domain.Contact;
import net.therap.addressbook.domain.User;
import net.therap.addressbook.service.ContactListService;
import net.therap.addressbook.service.ContactListServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: anjum
 * Date: 11/14/12
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/contact")
public class ContactController {
    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    ContactListService contactListService;
    ContactController(){
        contactListService=new ContactListServiceImpl();
    }
    @RequestMapping(value = "/newContactForm" , method = RequestMethod.GET)
    public String loadNewContactForm(Model model){
        Contact contact = new Contact();
        model.addAttribute("newContact" , contact);
        return "/contactForm";
    }
    @RequestMapping(value = "/addNewContact" , method = RequestMethod.POST)
    public String addNewContact(Contact contact , HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedInUser");
        contactListService.saveContact(contact,user);
        log.debug(contact.getName()+" "+contact.getAddress()+" "+contact.getPhoneNo()+"New Contact Information");
        return "redirect:/user/listOfContact";
    }
    @RequestMapping(value = "/editContactForm/{id}")
    public String loadeditContactForm(@PathVariable("id") int id,Model model){
        Contact contact = contactListService.getContact(id);
        model.addAttribute("wantToEdit" , id);
        model.addAttribute("contact",contact);
        return "/contactForm";
    }
    @RequestMapping(value = "/updateContact/{id}")
    public String loadeditContactForm(@PathVariable("id") int id , Contact contact , HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedInUser");
        if(user!=null){
           contactListService.updateContact(contact,user);
           return "redirect:/user/listOfContact";
        }
        return "/contactForm";


    }
    @RequestMapping(value = "/deleteContact/{id}")
    public String deleteContact(@PathVariable("id") int id , Contact contact , HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedInUser");
        if(user!=null){
            contactListService.deleteContact(id);

        }
        return "redirect:/user/listOfContact";

    }
}
