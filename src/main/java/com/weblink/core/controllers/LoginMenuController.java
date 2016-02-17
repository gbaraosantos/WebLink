package com.weblink.core.controllers;

import com.weblink.core.common.Logger;
import com.weblink.core.models.User;
import com.weblink.core.models.UserProfile;
import com.weblink.core.models.enums.State;
import com.weblink.core.models.enums.UserProfileType;
import com.weblink.core.services.UserProfileService.UserProfileService;
import com.weblink.core.services.registerService.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class LoginMenuController {

    @Autowired
    RegisterService registerService;

    @Autowired
    UserProfileService userProfileService;

    @RequestMapping(value="/loginForm", method = RequestMethod.GET)
    public String loginRequest(Model model) {
        model.addAttribute("errorMessage" , "Credenciais Inválidas");
        return "Login";
    }

    @RequestMapping(value="/registerForm", method = RequestMethod.POST)
    public String registerRequest(HttpServletRequest request) {
        String email, password, name, address, nationality;
        int postal1, postal2;
        int day_birth, month_birth, year_birth;
        Date birth;
        Set<UserProfile> userProfiles;
        UserProfile userProfile;

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
            userProfiles = new HashSet<UserProfile>();
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

            registerService.registration(user);

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




}
