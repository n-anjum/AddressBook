package net.therap.addressbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: anjum
 * Date: 11/13/12
 * Time: 12:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
//@RequestMapping("/addressbook")
@RequestMapping("")
public class HomePageController{
    @RequestMapping(value = "/homepage" , method= RequestMethod.GET)
    public String loadHomePage(){
        return "/homepage";
    }

}
