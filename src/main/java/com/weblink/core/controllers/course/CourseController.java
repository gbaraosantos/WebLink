package com.weblink.core.controllers.course;

import com.weblink.core.models.Action;
import com.weblink.core.models.Course;
import com.weblink.core.models.User;
import com.weblink.core.services.course_management_service.ActionManagementService;
import com.weblink.core.services.course_management_service.CourseManagementService;
import com.weblink.core.services.logger_service.LoggerService;
import com.weblink.core.services.user_service.UserService;
import com.weblink.core.validators.ActionValidator;
import com.weblink.core.validators.CourseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CourseController {

    @Autowired UserService userService;
    @Autowired LoggerService logger;
    @Autowired CourseManagementService courseManagementService;
    @Autowired ActionManagementService actionManagementService;

    private volatile User user;

    @RequestMapping(value = "/weblink/courses", method = RequestMethod.GET)
    public String getCourses(Model model){
        prepareModel(model);
        return "Courses";
    }

    @RequestMapping(value = "/coord/addCourse" , method = RequestMethod.POST)
    public String getCourseAdd(Model model, HttpServletRequest request){
        prepareModel(model);


        Action action = new CourseValidator().validateInput(request);

        if (action == null)  return "redirect:/weblink/courses?addCourse=false";

        courseManagementService.createCourse(action.getCourse());
        actionManagementService.createAction(action.setCourse(courseManagementService.getCourse(action.getCourse().getName())));

        return "redirect:/weblink/courses?addCourse=true";
    }

    @RequestMapping(value = "/coord/addAction" , method = RequestMethod.POST)
    public String getActionAdd(Model model, HttpServletRequest request){

        prepareModel(model);
        try{
            Course course = courseManagementService.getCourse(Integer.parseInt(request.getParameter("CourseID")));
            if(course == null) return "redirect:/weblink/courses?addCourse=false";

            Action action = new ActionValidator().validateInput(request, course);
            if (action == null)  return "redirect:/weblink/courses?addCourse=false";

            actionManagementService.createAction(action);
            return "redirect:/weblink/courses?addCourse=true";

        }catch (Exception e){
            return "redirect:/weblink/courses?addCourse=false";
        }

    }

    @RequestMapping(value="/weblink/courses", method = RequestMethod.GET, params = {"addCourse"})
    public String courseCreationFail(@RequestParam("addCourse") boolean addCourse, Model model) {
        prepareModel(model);

        if(addCourse)   model.addAttribute("SuccessCreating", "Sucesso a Adicionar Curso/Accao");
        else            model.addAttribute("FailureCreating", "Criação de Curso/Accao não foi bem sucedida");

        return "Courses";
    }

    @RequestMapping(value="/coord/deleteAction", method = RequestMethod.GET, params = {"Action"})
    public void deleteAction(@RequestParam("Action") int id, Model model) {
        prepareModel(model);
        actionManagementService.deleteAction(actionManagementService.getAction(id));

    }

    @RequestMapping(value = "/coord/changeVisibility" , method = RequestMethod.GET, params = {"Action"})
    public String changeVisibility(@RequestParam("Action") int id, Model model){
        prepareModel(model);
        actionManagementService.updateAction(actionManagementService.getAction(id).changeVisibility());
        return "redirect:/weblink/courses";
    }

    /*This is a comment*/

    @RequestMapping(value = "/coord/getModules" , method = RequestMethod.GET, params = {"Course"})
    public Course getCourseModules(@RequestParam("Course") int id, Model model, HttpServletResponse response) throws IOException {
        prepareModel(model);
        Course course = courseManagementService.getCourse(id);
        System.out.println(course);


        response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
        response.getWriter().write("Hello there ajax");       // Write response body.


        return course;
    }



    private Model prepareModel(Model model){
        user = userService.getSingleUser(getEmail());
        model.addAttribute("User", user);
        model.addAttribute("actions" , actionManagementService.getUpcoming());
        model.addAttribute("courses" , courseManagementService.getAll());
        return model;
    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
