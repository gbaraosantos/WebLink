package com.weblink.core.controllers.social;

import com.weblink.core.models.Platform;
import com.weblink.core.models.User;
import com.weblink.core.services.course_management_service.ActionManagementService;
import com.weblink.core.services.file_system_service.FileSystemService;
import com.weblink.core.services.logger_service.LoggerService;
import com.weblink.core.services.platform_service.PlatformService;
import com.weblink.core.services.student_management_service.StudentManagementService;
import com.weblink.core.services.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SocialController {
    @Autowired FileSystemService fileSystemService;
    @Autowired UserService userService;
    @Autowired private Environment environment;
    @Autowired PlatformService platformService;
    @Autowired LoggerService loggerService;
    @Autowired ActionManagementService actionManagementService;
    @Autowired StudentManagementService studentManagementService;

    private volatile User user;


    @RequestMapping(value ="/weblink/social", method = RequestMethod.GET)
    public String social(Model model){
        String tokenId;

        user = userService.getSingleUser(getEmail());
        model.addAttribute("User", user);



        platformService.registerGlobalChat();
        tokenId = platformService.getTokenId();

        Platform p = platformService.getPlaform();

        model.addAttribute("Online", userService.getOnlineUsers());


        if(p != null)       model.addAttribute("sessionId", p.getGlobalChatSession());
        if(tokenId != null) model.addAttribute("tokenId", tokenId);
        model.addAttribute("apiKey", environment.getRequiredProperty("opentok.apikey"));

        return "Social";
    }



    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
