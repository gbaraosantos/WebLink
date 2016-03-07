package com.weblink.core.controllers.screen;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MenuController {

    /*User Tried to Access a page to which he has no access*/
    @RequestMapping(value = "/AppMenu" , method = RequestMethod.GET)
    public String accessDeniedPage(Model model, HttpServletRequest request){
        String user = getEmail();
        model.addAttribute("user" , user);

        return "AppMenu";
    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
