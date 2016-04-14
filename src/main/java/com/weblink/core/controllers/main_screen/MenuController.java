package com.weblink.core.controllers.main_screen;

import com.weblink.core.models.Platform;
import com.weblink.core.models.User;
import com.weblink.core.services.file_system_service.FileSystemService;
import com.weblink.core.services.platform_service.PlatformService;
import com.weblink.core.services.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@PropertySource(value = "classpath:weblink.properties")
@Controller
public class MenuController {
    @Autowired FileSystemService fileSystemService;
    @Autowired UserService userService;
    @Autowired private Environment environment;
    @Autowired PlatformService platformService;


    private volatile User user;

    /*User Tried to Access a page to which he has no access*/
    @RequestMapping(value = "/weblink" , method = RequestMethod.GET)
    public String getAppMenu(Model model){
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

        return "weblink";
    }





    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
