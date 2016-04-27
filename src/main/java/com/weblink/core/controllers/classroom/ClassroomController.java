package com.weblink.core.controllers.classroom;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opentok.OpenTok;
import com.opentok.Role;
import com.opentok.TokenOptions;
import com.opentok.exception.OpenTokException;
import com.weblink.core.models.*;
import com.weblink.core.services.class_management_service.ClassService;
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
import java.util.*;

@Controller
@PropertySource(value = { "classpath:weblink.properties" })
public class ClassroomController {
    @Autowired ActionManagementService actionManagementService;
    @Autowired TeacherManagementService teacherService;
    @Autowired UserService userService;
    @Autowired ModuleActionManagementService moduleActionManagementService;
    @Autowired private Environment environment;
    @Autowired ClassService classService;

    private volatile User user;

    @RequestMapping(value ="/weblink/classroom", method = RequestMethod.GET, params = {"mpa"})
    public String classroom(@RequestParam("mpa") int id, Model model, HttpServletRequest request) throws OpenTokException {
        OpenTok openTok = new OpenTok(Integer.parseInt(environment.getRequiredProperty("opentok.apikey")), environment.getRequiredProperty("opentok.secretkey"));
        user = userService.getSingleUser(getEmail());

        model.addAttribute("User", user);

        ModulePerAction mpa = moduleActionManagementService.getMpa(id);
        if(mpa == null) return "redirect:/weblink";

        TokenOptions tokenOptionsMod = new TokenOptions.Builder()
                .data(Integer.toString(user.getId()))
                .role(Role.PUBLISHER)
                .build();

        TokenOptions tokenOptionsSub = new TokenOptions.Builder()
                .data(Integer.toString(user.getId()))
                .role(Role.SUBSCRIBER)
                .build();

        model.addAttribute("usersInRoom", classService.getUsers(id) );
        model.addAttribute("mpa", mpa);

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

    @RequestMapping(value ="/weblink/conference", method = RequestMethod.GET, params = {"mpa"})
    public String conference(@RequestParam("mpa") int id, Model model, HttpServletRequest request) throws OpenTokException {
        OpenTok openTok = new OpenTok(Integer.parseInt(environment.getRequiredProperty("opentok.apikey")), environment.getRequiredProperty("opentok.secretkey"));
        user = userService.getSingleUser(getEmail());

        model.addAttribute("User", user);

        ModulePerAction mpa = moduleActionManagementService.getMpa(id);
        if(mpa == null) return "redirect:/weblink";

        TokenOptions tokenOptionsMod = new TokenOptions.Builder()
                .data(Integer.toString(user.getId()))
                .role(Role.PUBLISHER)
                .build();

        model.addAttribute("mpa", mpa);
        model.addAttribute("tokenId", openTok.generateToken(mpa.getAction().getClassroomSession(),tokenOptionsMod));

        model.addAttribute("apiKey", environment.getRequiredProperty("opentok.apikey"));
        model.addAttribute("sessionId", mpa.getAction().getClassroomSession());

        return "Conference";
    }


    @RequestMapping(value ="/weblink/classroomUsers", method = RequestMethod.GET, params = {"id" , "data"})
    public @ResponseBody String addUser(@RequestParam("id") int id,@RequestParam("data") String metadata, Model model, HttpServletRequest request) {
        classService.addUser(metadata, id);
        return "Social";
    }

    @RequestMapping(value ="/weblink/classroomUsersRemove", method = RequestMethod.GET, params = {"id" , "data"})
    public @ResponseBody String removeUser(@RequestParam("id") int id,@RequestParam("data") String metadata, Model model, HttpServletRequest request) {
        classService.removeUser(metadata, id);
        return "Social";
    }

    @RequestMapping(value ="/weblink/classroomMessageAdd", method = RequestMethod.GET, params = {"data" , "userId"})
    public @ResponseBody String addMessage(@RequestParam("data") String data,@RequestParam("userId") int userId, Model model, HttpServletRequest request) {
        classService.persistMessage(data, userId);
        return "Social";
    }

    @RequestMapping(value ="/weblink/classroomMessageGet", method = RequestMethod.GET)
    public @ResponseBody String getAllMessages(Model model, HttpServletRequest request) throws JsonProcessingException {
        return   new ObjectMapper().writeValueAsString(classService.getAllMessages());
    }



    @RequestMapping(value ="/weblink/getUsers", method = RequestMethod.GET, params = {"data"})
    public @ResponseBody String addUser(@RequestParam("data") String metadata, Model model, HttpServletRequest request) throws JsonProcessingException {
        List<Map<String, String>> map = new LinkedList<>();


        List<User> userList = classService.getUsers(Integer.parseInt(metadata));

        for(User user: userList){
            Map<String, String> temp = new HashMap<>();

            temp.put("id" , String.valueOf(user.getId()));
            temp.put("name" , user.getName());
            temp.put("avatarLocation" , user.getAvatarLocation());
            temp.put("email" , user.getEmail());


            map.add(temp);

        }

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(map);

        return result;
    }






















    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }


}
