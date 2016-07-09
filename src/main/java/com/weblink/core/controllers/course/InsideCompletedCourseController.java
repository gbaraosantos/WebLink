package com.weblink.core.controllers.course;

import com.weblink.core.models.*;
import com.weblink.core.services.certificate_management_service.CertificateManagementService;
import com.weblink.core.services.course_management_service.ActionManagementService;
import com.weblink.core.services.messaging_service.MessageService;
import com.weblink.core.services.student_management_service.StudentManagementService;
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

import java.util.Date;
import java.util.List;

@Controller
public class InsideCompletedCourseController {
    @Autowired UserService userService;
    @Autowired StudentManagementService studentManagementService;
    @Autowired ActionManagementService actionManagementService;
    @Autowired MessageService messageService;
    @Autowired FriendService friendService;
    @Autowired CertificateManagementService certificateManagementService;

    private volatile User user;

    @RequestMapping(value = "/weblink/completedCourse", method = RequestMethod.GET, params = {"action"})
    public String actionPage(@RequestParam("action") int actionId, Model model) {
        prepareModel(model, actionId);


        return "inCompletedCourse";
    }

    @RequestMapping(value = "/getCertificate", method = RequestMethod.GET, params = {"student"})
    public String getCertificateRequest(@RequestParam("student") int studentId, Model model) {
        Student student = studentManagementService.getStudent(studentId);
        if(student == null) return "/weblink";

        certificateManagementService.addCertificateRequest(
                new CertificateRequest()
                        .setAction(student.getAction())
                        .setStudent(student)
                        .setCreationDate(new Date())
        );

        prepareModel(model, student.getAction().getId());
        return "inCompletedCourse";
    }

    private void prepareModel(Model model, int actionId) {
        user = userService.getSingleUser(getEmail());
        if(user != null) model.addAttribute("User", user);

        Action action = actionManagementService.getAction(actionId);
        if(action != null) model.addAttribute("action", action);

        Student student = studentManagementService.getStudent(action,user);
        if(student != null) model.addAttribute("student", student);

        System.out.println(student);

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

    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
