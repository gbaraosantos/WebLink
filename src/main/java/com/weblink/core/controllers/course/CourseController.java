package com.weblink.core.controllers.course;

import com.weblink.core.common.file.FileBucket;
import com.weblink.core.models.User;
import com.weblink.core.services.logger_service.LoggerService;
import com.weblink.core.services.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {

    @Autowired UserService userService;
    @Autowired LoggerService logger;

    private volatile User user;

    @RequestMapping(value = "/weblink/courses", method = RequestMethod.GET)
    public String getCourses(Model model){
        user = userService.getSingleUser(getEmail());
        model.addAttribute("User", user);
        model.addAttribute("fileBucket" , new FileBucket());
        return "Courses";
    }

    @RequestMapping(value = "/coord/addCourse" , method = RequestMethod.GET)
    public String getCourseAdd(Model model){
        user = userService.getSingleUser(getEmail());
        model.addAttribute("User", user);
        model.addAttribute("fileBucket" , new FileBucket());
        return "AddCourse";
    }




    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
