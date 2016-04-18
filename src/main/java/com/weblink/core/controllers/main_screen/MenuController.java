package com.weblink.core.controllers.main_screen;

import com.weblink.core.models.Platform;
import com.weblink.core.models.User;
import com.weblink.core.services.course_management_service.ActionManagementService;
import com.weblink.core.services.file_system_service.FileSystemService;
import com.weblink.core.services.logger_service.LoggerService;
import com.weblink.core.services.platform_service.PlatformService;
import com.weblink.core.services.student_management_service.StudentManagementService;
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
    @Autowired LoggerService loggerService;
    @Autowired ActionManagementService actionManagementService;
    @Autowired StudentManagementService studentManagementService;


    private volatile User user;

    /*User Tried to Access a page to which he has no access*/
    @RequestMapping(value = "/weblink" , method = RequestMethod.GET)
    public String getAppMenu(Model model){
        user = userService.getSingleUser(getEmail());
        model.addAttribute("User", user);

        if (studentManagementService.getAllStudents() != null) model.addAttribute("nrStudents" , studentManagementService.getAllStudents().size());
        else model.addAttribute("nrStudents",0);

        if(userService.getAllUsers() != null) model.addAttribute("nrUsers" , userService.getAllUsers().size());
        else model.addAttribute("nrUsers",0);


        model.addAttribute("nrActions" , actionManagementService.nrActions());
        model.addAttribute("nrLoginsMonth" , loggerService.getLoginNumber(getEmail(),30));
        model.addAttribute("eventsPerDay", loggerService.getEventsPerNDays(3 , getEmail()));


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
