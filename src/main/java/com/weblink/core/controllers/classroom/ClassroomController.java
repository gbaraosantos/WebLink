package com.weblink.core.controllers.classroom;

import com.opentok.OpenTok;
import com.opentok.Role;
import com.opentok.TokenOptions;
import com.opentok.exception.OpenTokException;
import com.weblink.core.models.Action;
import com.weblink.core.models.FriendRequest;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.User;
import com.weblink.core.services.course_management_service.ActionManagementService;
import com.weblink.core.services.module_action_management_service.ModuleActionManagementService;
import com.weblink.core.services.teacher_management_service.TeacherManagementService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@PropertySource(value = { "classpath:weblink.properties" })
public class ClassroomController {
    @Autowired ActionManagementService actionManagementService;
    @Autowired TeacherManagementService teacherService;
    @Autowired UserService userService;
    @Autowired ModuleActionManagementService moduleActionManagementService;
    @Autowired private Environment environment;
    private volatile User user;

    @RequestMapping(value ="/weblink/classroom", method = RequestMethod.GET, params = {"mpa"})
    public String deleteRequest(@RequestParam("mpa") int id, Model model, HttpServletRequest request) throws OpenTokException {
        OpenTok openTok = new OpenTok(Integer.parseInt(environment.getRequiredProperty("opentok.apikey")), environment.getRequiredProperty("opentok.secretkey"));
        user = userService.getSingleUser(getEmail());

        ModulePerAction mpa = moduleActionManagementService.getMpa(id);
        if(mpa == null) return "redirect:/weblink";

        TokenOptions tokenOptionsMod = new TokenOptions.Builder()
                .role(Role.PUBLISHER)
                .build();

        TokenOptions tokenOptionsSub = new TokenOptions.Builder()
                .role(Role.SUBSCRIBER)
                .build();

        if (teacherService.isTeacher(mpa,user)){
            model.addAttribute("isTeacher", "True");
            model.addAttribute("tokenId", openTok.generateToken(mpa.getAction().getClassroomSession(),tokenOptionsMod));
        }
        else{
            model.addAttribute("isTeacher", "false");
            model.addAttribute("tokenId", openTok.generateToken(mpa.getAction().getClassroomSession(),tokenOptionsSub));
        }

        model.addAttribute("apiKey", environment.getRequiredProperty("opentok.apikey"));
        model.addAttribute("sessionId", mpa.getAction().getClassroomSession());

        return "Classroom";
    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }


}
