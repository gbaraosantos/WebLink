package com.weblink.core.controllers.course;

import com.weblink.core.common.file.FileBucket;
import com.weblink.core.models.Action;
import com.weblink.core.models.Course;
import com.weblink.core.models.User;
import com.weblink.core.services.course_management_service.ActionManagementService;
import com.weblink.core.services.course_management_service.CourseManagementService;
import com.weblink.core.services.logger_service.LoggerService;
import com.weblink.core.services.user_service.UserService;
import com.weblink.core.validators.CourseValidator;
import com.weblink.core.validators.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CourseController {

    @Autowired UserService userService;
    @Autowired LoggerService logger;
    @Autowired CourseManagementService courseManagementService;
    @Autowired ActionManagementService actionManagementService;

    private volatile User user;

    @RequestMapping(value = "/weblink/courses", method = RequestMethod.GET)
    public String getCourses(Model model){
        user = userService.getSingleUser(getEmail());
        model.addAttribute("User", user);
        return "Courses";
    }

    @RequestMapping(value = "/coord/addCourse" , method = RequestMethod.POST)
    public String getCourseAdd(Model model, HttpServletRequest request){
        user = userService.getSingleUser(getEmail());
        model.addAttribute("User", user);

        Action action = new CourseValidator().validateInput(request);

        if (action == null)  return "redirect:/weblink/courses?addCourse=false";

        courseManagementService.createCourse(action.getCourse());
        System.out.println(action);
        actionManagementService.createAction(action.setCourse(courseManagementService.getCourse(action.getCourse().getName())));

        return "Courses";
    }

    @RequestMapping(value="/weblink/courses", method = RequestMethod.GET, params = {"addCourse"})
    public String courseCreationFail(@RequestParam("addCourse") boolean addCourse, Model model) {
        user = userService.getSingleUser(getEmail());
        model.addAttribute("User", user);

        if(addCourse)   model.addAttribute("SuccessCreating", "Sucesso a Adicionar Curso");
        else            model.addAttribute("FailureCreating", "Criação de Curso não foi bem sucedida");

        return "Courses";
    }




    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
