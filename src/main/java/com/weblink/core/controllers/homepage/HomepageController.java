package com.weblink.core.controllers.homepage;

import com.weblink.core.services.logger_service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
public class HomepageController {
    @Autowired LoggerService logger;


    /*User Tried to Access a page to which he has no access*/
    @RequestMapping(value = "/accessDenied" , method = RequestMethod.GET)
    public String accessDeniedPage(Model model, HttpServletRequest request){
        model.addAttribute("user", getEmail());

        Map<String, Object> json = new HashMap<>();
        json.put("email" , getEmail());
        json.put("type", "AccessDenied");
        json.put("url" , request.getAttribute("javax.servlet.forward.request_uri") );
        logger.log(json,"403");

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
