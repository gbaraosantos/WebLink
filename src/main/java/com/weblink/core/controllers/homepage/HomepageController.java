package com.weblink.core.controllers.homepage;

import com.weblink.core.common.Logger;
import org.json.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {

    /*User Tried to Access a page to which he has no access*/
    @RequestMapping(value = "/accessDenied" , method = RequestMethod.GET)
    public String accessDeniedPage(Model model){
        JSONObject log = new JSONObject();
        model.addAttribute("user", getEmail());

        log     .append("email" , getEmail())
                .append("accessDenied", "Registration");


        new Logger().log(log);
        return "403";
    }


    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }


}
