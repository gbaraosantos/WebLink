package com.weblink.core.controllers.course;

import com.weblink.core.common.enums.UserProfileType;
import com.weblink.core.models.Action;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.User;
import com.weblink.core.services.course_management_service.ActionManagementService;
import com.weblink.core.services.student_management_service.StudentManagementService;
import com.weblink.core.services.teacher_management_service.TeacherManagementService;
import com.weblink.core.services.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyCoursesController {
    @Autowired UserService userService;
    @Autowired StudentManagementService studentManagementService;
    @Autowired ActionManagementService actionManagementService;
    @Autowired TeacherManagementService teacherManagementService;

    private volatile User user;

    @RequestMapping(value = "/weblink/myCourses", method = RequestMethod.GET)
    public String actionPage( Model model) {
        prepareModel(model);
        return "CourseChoice";
    }

    private void prepareModel(Model model) {
        user = userService.getSingleUser(getEmail());

        if(user != null) model.addAttribute("User", user);

        List<Action> attending = studentManagementService.getAttending(user);
        List<Action> teaching = teacherManagementService.getTeaching(user);

        if(attending == null && teaching ==null)    model.addAttribute("NoActionsSubbed", "Nao se encontra inscrito em nenhum curso");

        model.addAttribute("attending", attending);
        model.addAttribute("teaching", teaching);

    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }


}
