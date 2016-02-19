package com.weblink.core.controllers.registerLogin;

import com.weblink.core.common.Logger;
import com.weblink.core.controllers.registerLogin.registerValidator;
import com.weblink.core.models.User;
import com.weblink.core.models.UserProfile;
import com.weblink.core.models.enums.State;
import com.weblink.core.models.enums.UserProfileType;
import com.weblink.core.services.email_service.EmailService;
import com.weblink.core.services.user_profile_service.UserProfileService;
import com.weblink.core.services.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class LoginMenuController {

    @Autowired UserService userService;
    @Autowired UserProfileService userProfileService;
    @Autowired EmailService emailService;


    /* /loginMenu Request to change to the login Menu*/
    @RequestMapping(value = "/loginMenu" , method = RequestMethod.GET)
    public String redirectLogin(){
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) return ("redirect:/");
        return "Login";
    }

    /* /logout Receives a Logout Request*/
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutRequest (HttpServletRequest request, HttpServletResponse response) {
        if ((SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) return ("redirect:/");
        new Logger().log(getEmail() + ": Logged out");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) new SecurityContextLogoutHandler().logout(request, response, auth);
        return "redirect:/loginMenu?logout=true";
    }

    /* /loginMenu?logout = 1 Logout was Successful */
    @RequestMapping(value="/loginMenu", method = RequestMethod.GET, params = {"logout"})
    public String logoutSuccessful(@RequestParam("logout") String val, Model model) {
        return "Login";
    }

    /* /loginMenu?logout = 1 Logout was Successful */
    @RequestMapping(value="/loginMenu", method = RequestMethod.GET, params = {"expired"})
    public String sessionExpires(@RequestParam("expired") String val, Model model) {
        if(val.equals("true")) new Logger().log("A user session expired");
        model.addAttribute("errorMessage" , "A sua sessão expirou");
        return "Login";
    }

    /* /loginForm?error Someone failed Login */
    @RequestMapping(value="/loginForm", method = RequestMethod.GET, params = {"error"})
    public String loginError(@RequestParam("error") String val, Model model) {
        new Logger().log(val + "Someone Failed to Login");
        model.addAttribute("errorMessage" , "Credenciais Inválidas");
        return "Login";
    }

    /* /loginMenu?logout = 1 Logout was Successful */
    @RequestMapping(value="/loginMenu", method = RequestMethod.GET, params = {"register"})
    public String registerSuccess(@RequestParam("register") Boolean val, Model model) {
        if (val) model.addAttribute("successRegister","Registo bem sucedido, confirme o seu email");
        else model.addAttribute("errorMessage", "Erro no Registo, email já utilizado");
        return "Login";
    }

    /* /registerForm Someone is Trying to Register */
    @RequestMapping(value="/registerForm", method = RequestMethod.POST)
    public String registerRequest(HttpServletRequest request) {
        Set<UserProfile> userProfiles = new HashSet<>();
        String token;

        userProfiles.add(userProfileService.getUserProfileByType(UserProfileType.USER));
        User user = new registerValidator().validateInput(request,userProfiles);

        if(user == null) return "redirect:/loginMenu?register=false";

        if (!userService.register(user)) return "redirect:/loginMenu?register=false";

        token = userService.createVerificationToken(user);
        emailService.sendRegistrationEmail(user,token);

        new Logger().log("Account Created: " + user );
        return "redirect:/loginMenu?register=true";
    }

    /* /loginMenu?logout = 1 Logout was Successful */
    @RequestMapping(value="/regitrationConfirm", method = RequestMethod.GET, params = {"token"})
    public String registrationConfirmation(@RequestParam("token") String token, Model model) {
        if (token == null){
            model.addAttribute("errorMessage", "Token invalida");
            return "Login";
        }

        User user = userService.getUser(token);

        if (user == null){
            model.addAttribute("errorMessage", "Token invalida");
            return "Login";
        }

        userService.activateAccount(user.setState(State.ACTIVE.getState()));
        model.addAttribute("successRegister","Account confirmada");
        return "Login";
    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }




}
