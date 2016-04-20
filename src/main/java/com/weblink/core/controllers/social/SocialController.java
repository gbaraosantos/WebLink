package com.weblink.core.controllers.social;

import com.weblink.core.models.*;
import com.weblink.core.services.course_management_service.ActionManagementService;
import com.weblink.core.services.file_system_service.FileSystemService;
import com.weblink.core.services.logger_service.LoggerService;
import com.weblink.core.services.messaging_service.MessageService;
import com.weblink.core.services.platform_service.PlatformService;
import com.weblink.core.services.student_management_service.StudentManagementService;
import com.weblink.core.services.user_service.FriendService;
import com.weblink.core.services.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SocialController {
    @Autowired FileSystemService fileSystemService;
    @Autowired UserService userService;
    @Autowired private Environment environment;
    @Autowired PlatformService platformService;
    @Autowired LoggerService loggerService;
    @Autowired ActionManagementService actionManagementService;
    @Autowired StudentManagementService studentManagementService;
    @Autowired FriendService friendService;
    @Autowired MessageService messageService;

    private volatile User user;


    @RequestMapping(value ="/weblink/social", method = RequestMethod.GET)
    public String social(Model model){
        prepareModel(model);

        return "Social";
    }

    @RequestMapping(value ="/weblink/deleteFriendRequest", method = RequestMethod.GET, params = {"id"})
    public @ResponseBody String deleteRequest(@RequestParam("id") int id, Model model, HttpServletRequest request) {
        FriendRequest request1 = friendService.getFriend(id);
        if(request1 != null) friendService.removeFriend(request1);
        prepareModel(model);
        return "Social";
    }

    @RequestMapping(value ="/weblink/acceptFriendRequest", method = RequestMethod.GET, params = {"id"})
    public @ResponseBody String acceptRequest(@RequestParam("id") int id, Model model, HttpServletRequest request) {
        friendService.acceptFriendRequest(id);
        prepareModel(model);
        return "Social";
    }

    @RequestMapping(value ="/weblink/offerCourse", method = RequestMethod.GET, params = {"friend" , "action"})
    public @ResponseBody String offerCourse(@RequestParam("friend") int friend, @RequestParam("action") int action, Model model, HttpServletRequest request) {
        prepareModel(model);
        User friendToOffer = userService.getSingleUser(friend);
        Action actionToOffer = actionManagementService.getAction(action);

        if(friendToOffer == null || actionToOffer == null) return "Social";

        Student student = studentManagementService.getStudent(actionToOffer,user);
        studentManagementService.removeStudent(student);

        studentManagementService.addStudent(
                new Student()
                        .setAction(actionToOffer)
                        .setBuyDate(student.getBuyDate())
                        .setBuyPrice(student.getBuyPrice())
                        .setFinalGrade(0)
                        .setUser(friendToOffer)
        );

        return "Social";
    }

    @RequestMapping(value ="/weblink/message", method = RequestMethod.GET, params = {"friend" , "message", "subject"})
    public @ResponseBody String message(@RequestParam("friend") int friend,@RequestParam("subject") String subject, @RequestParam("message") String message, Model model, HttpServletRequest request) {
        prepareModel(model);
        User destination = userService.getSingleUser(friend);

        EmailApp newMessage = new EmailApp()
                .setBeenRead(false)
                .setBody(message)
                .setFrom(user)
                .setSubject(subject)
                .setTo(destination);

        messageService.sendMessage(newMessage);
        return "Social";
    }



    @RequestMapping(value ="/weblink/newFriendRequest", method = RequestMethod.POST)
    public String friendRequest(Model model, HttpServletRequest request) {
        String email = request.getParameter("requestEmail");
        User userTo;

        prepareModel(model);

        if(email == null || !(email.length() > 2) || !(email.length() < 256)){
            model.addAttribute("errorRequest", "Request Inválido");
            return "Social";

        }
        if (!alreadyExistsOrFriend(email)){

            userTo = userService.getSingleUser(email);

            if(userTo == null)  model.addAttribute("errorRequest", "Esse utilizador não existe");
            else{
                friendService.addFriend(new FriendRequest()
                        .setAccepted(false)
                        .setUserA(user)
                        .setUserB(userTo)
                        .setRequestDate(new Date())
                        .setAccepteDate(null));
            }

            prepareModel(model);
        }
        else{
            model.addAttribute("errorRequest", "Esse request já existe ou já é amigo desse user");
        }



        return "Social";
    }

    private boolean alreadyExistsOrFriend(String email) {
        List<FriendRequest> users1 = friendService.getFromMePending(user);
        List<FriendRequest> users2 = friendService.getToMePending(user);
        List<FriendRequest> users3 = friendService.getFriends(user);

        if(users1 != null){
            for(FriendRequest fr : users1){
                if(fr.getUserA().getEmail().equals(email)) return true;
            }
        }

        if(users2 != null){
            for(FriendRequest fr : users2){
                if(fr.getUserB().getEmail().equals(email)) return true;
            }
        }
        if(users3 != null){
            for(FriendRequest fr : users3){
                if(fr.getUserB().getEmail().equals(email)) return true;
                if(fr.getUserA().getEmail().equals(email)) return true;
            }
        }

        return false;


    }


    private void prepareModel(Model model){
        String tokenId;
        user = userService.getSingleUser(getEmail());

        List<FriendRequest> list = friendService.getToMePending(user);
        List<EmailApp> sentList = messageService.sentMessages(user);
        List<EmailApp> receivedList = messageService.receivedMessage(user);
        List<EmailApp> receivedUnreadList = messageService.receivedUnreadMessage(user);

        model.addAttribute("User", user);
        model.addAttribute("myActions", studentManagementService.getAttending(user));
        model.addAttribute("fromMePending", friendService.getFromMePending(user));
        model.addAttribute("toMePending", list );
        model.addAttribute("friendListing" , friendService.getFriends(user));
        model.addAttribute("sentList" , sentList);
        model.addAttribute("receivedList", receivedList);

        if(list != null) model.addAttribute("nrRequestsPending" , list.size());
        if(receivedList != null) model.addAttribute("nrMessages", receivedUnreadList.size());


        platformService.registerGlobalChat();
        tokenId = platformService.getTokenId();

        Platform p = platformService.getPlaform();

        model.addAttribute("Online", userService.getOnlineUsers());

        if(p != null)       model.addAttribute("sessionId", p.getGlobalChatSession());
        if(tokenId != null) model.addAttribute("tokenId", tokenId);
        model.addAttribute("apiKey", environment.getRequiredProperty("opentok.apikey"));
    }



    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
