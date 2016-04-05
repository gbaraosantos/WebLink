package com.weblink.core.controllers.course;


import com.weblink.core.models.Action;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.Teacher;
import com.weblink.core.models.User;
import com.weblink.core.services.course_management_service.ActionManagementService;
import com.weblink.core.services.course_management_service.CourseManagementService;
import com.weblink.core.services.course_management_service.ModuleManagementService;
import com.weblink.core.services.logger_service.LoggerService;
import com.weblink.core.services.module_action_management_service.ModuleActionManagementService;
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
public class CourseDetailsController {
    @Autowired  UserService userService;
    @Autowired  LoggerService logger;
    @Autowired  CourseManagementService courseManagementService;
    @Autowired  ActionManagementService actionManagementService;
    @Autowired  ModuleManagementService moduleManagementService;
    @Autowired  ModuleActionManagementService moduleActionManagementService;

    private volatile User user;


    @RequestMapping(value = "/weblink/action", method = RequestMethod.GET, params = {"action"})
    public String actionPage(@RequestParam("action") int actionId, Model model) {
        prepareModel(model, actionId);


        return "CourseDetails";
    }

    private void prepareModel(Model model, int actionId) {
        Action a = actionManagementService.getAction(actionId);
        List<ModulePerAction> list = moduleActionManagementService.getMpa(a);

        user = userService.getSingleUser(getEmail());
        model.addAttribute("User", user);
        model.addAttribute("action" , a);



        if(list == null){
            model.addAttribute("noMPA", "Não Existem Módulos para esta acção");
        }
        else{
            System.out.println(list.get(0).getTeacherList());
            System.out.println(list.get(1).getTeacherList());
            model.addAttribute("MPAList", list);
        }


    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
