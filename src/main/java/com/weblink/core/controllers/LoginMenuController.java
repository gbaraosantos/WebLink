package com.weblink.core.controllers;

import com.weblink.core.common.Logger;
import com.weblink.core.models.User;
import com.weblink.core.models.UserProfile;
import com.weblink.core.models.enums.State;
import com.weblink.core.models.enums.UserProfileType;
import com.weblink.core.services.user_profile_service.UserProfileService;
import com.weblink.core.services.user_service.UserService;
import com.weblink.core.configurations.application_configuration.AppConfiguration;
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


    /* /loginMenu Request to change to the login Menu*/
    @RequestMapping(value = "/loginMenu" , method = RequestMethod.GET)
    public String redirectLogin(){
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) return ("redirect:/");
        return "Login";
    }

    /* /logout Receives a Logout Request*/
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
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

    /* /registerForm Someone is Trying to Register */
    @RequestMapping(value="/registerForm", method = RequestMethod.POST)
    public String registerRequest(HttpServletRequest request) {
        String email, password, name, address, nationality;
        int postal1, postal2;
        int day_birth, month_birth, year_birth;
        Date birth;
        Set<UserProfile> userProfiles;



        Map<String, String[]> parameters = request.getParameterMap();

        if (
                    !parameters.containsKey("email")            ||
                    !parameters.containsKey("password")         ||
                    !parameters.containsKey("name")             ||
                    !parameters.containsKey("address")          ||
                    !parameters.containsKey("dia_reg")          ||
                    !parameters.containsKey("mes_reg")          ||
                    !parameters.containsKey("ano_reg")          ||
                    !parameters.containsKey("nationality")      ||
                    !parameters.containsKey("postal1")          ||
                    !parameters.containsKey("postal2")
        )return "Login";

        try{
            email = request.getParameter("email");
            password = request.getParameter("password");
            name = request.getParameter("name");
            address = request.getParameter("address");
            nationality = request.getParameter("nationality");
            postal1 = Integer.parseInt(request.getParameter("postal1"));
            postal2 = Integer.parseInt(request.getParameter("postal2"));
            day_birth = Integer.parseInt(request.getParameter("dia_reg"));
            month_birth = Integer.parseInt(request.getParameter("mes_reg"));
            year_birth = Integer.parseInt(request.getParameter("ano_reg"));

            birth = dateConversion(year_birth,month_birth,day_birth);
            userProfiles = new HashSet<>();
            userProfiles.add(userProfileService.getUserProfileByType(UserProfileType.USER));

            User user = new User()
                    .setEmail(email)
                    .setPassword(password)
                    .setName(name)
                    .setAddress(address)
                    .setDateBirth(birth)
                    .setNationality(nationality)
                    .setPostal1(postal1)
                    .setPostal2(postal2)
                    .setRegDate(new Date())
                    .setLastChangeDate(new Date())
                    .setState(State.ACTIVE.getState())
                    .setUserProfiles(userProfiles);

            userService.register(user);

        }catch (NumberFormatException exception){   new Logger().err_log("Number Format Exception: LoginMenuController.Java Line 63");  }



        return "Login";
    }

    private Date dateConversion(int year, int month, int day){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);

        return cal.getTime();
    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }




}
