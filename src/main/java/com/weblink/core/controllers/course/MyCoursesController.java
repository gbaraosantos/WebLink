package com.weblink.core.controllers.course;

import com.weblink.core.common.enums.UserProfileType;
import com.weblink.core.models.*;
import com.weblink.core.services.course_management_service.ActionManagementService;
import com.weblink.core.services.messaging_service.MessageService;
import com.weblink.core.services.student_management_service.StudentManagementService;
import com.weblink.core.services.teacher_management_service.TeacherManagementService;
import com.weblink.core.services.user_service.FriendService;
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
    @Autowired MessageService messageService;
    @Autowired FriendService friendService;

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

        System.out.println(teaching);

        List<FriendRequest> list = friendService.getToMePending(user);
        List<EmailApp> sentList = messageService.sentMessages(user);
        List<EmailApp> receivedList = messageService.receivedMessage(user);
        List<EmailApp> receivedUnreadList = messageService.receivedUnreadMessage(user);

        model.addAttribute("fromMePending", friendService.getFromMePending(user));
        model.addAttribute("toMePending", list );
        model.addAttribute("friendListing" , friendService.getFriends(user));
        model.addAttribute("sentList" , sentList);
        model.addAttribute("receivedList", receivedList);

        if(list != null) model.addAttribute("nrRequestsPending" , list.size());
        if(receivedUnreadList != null) model.addAttribute("nrMessages", receivedUnreadList.size());

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
