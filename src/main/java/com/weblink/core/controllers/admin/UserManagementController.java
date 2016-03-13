package com.weblink.core.controllers.admin;

import com.weblink.core.common.enums.State;
import com.weblink.core.common.enums.UserProfileType;
import com.weblink.core.models.User;
import com.weblink.core.models.UserProfile;
import com.weblink.core.services.logger_service.LoggerService;
import com.weblink.core.services.user_profile_service.UserProfileService;
import com.weblink.core.services.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class UserManagementController {
    @Autowired UserService userService;
    @Autowired UserProfileService userProfileService;
    @Autowired LoggerService logger;

    private volatile User user;


    @RequestMapping(value = "/admin/userManagement")
    public String getUserManagement(Model model){
        user = userService.getSingleUser(getEmail());
        model.addAttribute("User", user);

        List listUsers = userService.getAllUsers();

        if(listUsers == null || listUsers.size() == 0) model.addAttribute("ErrorMessage" , "Nao existem utilizadores");


        model.addAttribute("userList" , listUsers);
        return "UserManagement";
    }

    @RequestMapping(value = "/admin/ban", params = {"user_id"})
    public String banUser(@RequestParam(value = "user_id") Integer userId, Model model){
        User user = userService.getSingleUser(userId);

        user.setState(State.LOCKED.getState());
        userService.updateUser(user);

        model.addAttribute("User", this.user);
        List listUsers = userService.getAllUsers();

        if(listUsers == null || listUsers.size() == 0) model.addAttribute("ErrorMessage" , "Nao existem utilizadores");
        else model.addAttribute("SuccessMessage", "Utilizador banido com sucesso");

        Map<String, Object> log = new HashMap<>();
        log.put("email" , user.getEmail());
        log.put("type" , "Ban");
        logger.log(log, "INFO");

        model.addAttribute("userList" , listUsers);
        return "UserManagement";
    }

    @RequestMapping(value = "/admin/unban", params = {"user_id"})
    public String unBanUser(@RequestParam(value = "user_id") Integer userId, Model model){
        User user = userService.getSingleUser(userId);

        if(user.getState().equals(State.ACTIVE.getState())){
            model.addAttribute("ErrorMessage" , "O utilizador ja tem a conta activada");
        }
        else if(user.getState().equals(State.INACTIVE.getState())){
            model.addAttribute("ErrorMessage" , "Nem tu tens permissoes para dar bypass a confirmacao de email");
        }else{
            model.addAttribute("SuccessMessage", "Utilizador banido com sucesso");

            Map<String, Object> log = new HashMap<>();
            log.put("email" , user.getEmail());
            log.put("type" , "unBan");
            logger.log(log, "INFO");

            user.setState(State.ACTIVE.getState());
            userService.updateUser(user);
        }

        model.addAttribute("User", this.user);
        List listUsers = userService.getAllUsers();


        if(listUsers == null || listUsers.size() == 0) model.addAttribute("ErrorMessage" , "Nao existem utilizadores");

        model.addAttribute("userList" , listUsers);
        return "UserManagement";
    }

    @RequestMapping(value = "/admin/addPermission", params = {"user_id", "perm"})
    public String addPermission(@RequestParam(value = "user_id") Integer userId, @RequestParam(value = "perm") String perm, Model model){
        User user = userService.getSingleUser(userId);
        model.addAttribute("User", this.user);

        if(perm == null)                    model.addAttribute("ErrorMessage" , "Permissao Vazia");
        else if(user.hasPermission(perm))   model.addAttribute("ErrorMessage" , "O utilizador ja tem essa permissao");

        else{
            model.addAttribute("SuccessMessage", "Utilizador promovido com sucesso");

            Map<String, Object> log = new HashMap<>();
            log.put("email" , user.getEmail());
            log.put("type" , "permissionAdd");
            log.put("value" , perm);
            logger.log(log, "INFO");

            Set<UserProfile> userProfiles = user.getUserProfiles();
            userProfiles.add(userProfileService.getUserProfileByType(UserProfileType.getProfileType(perm)));
            userService.updateUser(user.setUserProfiles(userProfiles));
        }

        model.addAttribute("User", this.user);
        List listUsers = userService.getAllUsers();

        if(listUsers == null || listUsers.size() == 0) model.addAttribute("ErrorMessage" , "Nao existem utilizadores");
        model.addAttribute("userList" , listUsers);

        return "UserManagement";
    }

    @RequestMapping(value = "/admin/remPermission", params = {"user_id", "perm"})
    public String remPermission(@RequestParam(value = "user_id") Integer userId, @RequestParam(value = "perm") String perm, Model model){
        User user = userService.getSingleUser(userId);
        model.addAttribute("User", this.user);

        if(perm == null)                        model.addAttribute("ErrorMessage" , "Permissao Vazia");
        else if(!user.hasPermission(perm))      model.addAttribute("ErrorMessage" , "O utilizador nao tem essa permissao");

        else{
            model.addAttribute("SuccessMessage", "Utilizador despromovido com sucesso");

            Map<String, Object> log = new HashMap<>();
            log.put("email" , user.getEmail());
            log.put("type" , "permissionRemove");
            log.put("value" , perm);
            logger.log(log, "INFO");

            Set<UserProfile> userProfiles = user.getUserProfiles();
            userProfiles.remove(userProfileService.getUserProfileByType(UserProfileType.getProfileType(perm)));
            userService.updateUser(user.setUserProfiles(userProfiles));
        }

        model.addAttribute("User", this.user);
        List listUsers = userService.getAllUsers();

        if(listUsers == null || listUsers.size() == 0) model.addAttribute("ErrorMessage" , "Nao existem utilizadores");
        model.addAttribute("userList" , listUsers);

        return "UserManagement";
    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
