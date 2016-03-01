package com.weblink.core.controllers.homepage;

import com.weblink.core.services.logger_service.Logger;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory.*;
import org.json.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomepageController {

    /*User Tried to Access a page to which he has no access*/
    @RequestMapping(value = "/accessDenied" , method = RequestMethod.GET)
    public String accessDeniedPage(Model model){
        Map<String, Object> json = new HashMap<String, Object>();
        model.addAttribute("user", getEmail());

        json.put("email" , getEmail());
        json.put("type", "AccessDenied");


        new Logger().log(json);
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
