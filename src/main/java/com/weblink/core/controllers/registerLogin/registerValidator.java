package com.weblink.core.controllers.registerLogin;

import com.weblink.core.common.Logger;
import com.weblink.core.models.User;
import com.weblink.core.models.UserProfile;
import com.weblink.core.models.enums.State;
import com.weblink.core.models.enums.UserProfileType;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


public class registerValidator {

    public User validateInput(HttpServletRequest request , Set<UserProfile> userProfiles) {

        if(!hasAllValues(request)) return null;

        User user;
        user = mapUser(request,userProfiles);

        if(user == null) return null;
        if(!checkNullAndSize(user.getAddress() , 3 , 256)) return null;
        if(!checkNullAndSize(user.getEmail() , 3 , 128)) return null;
        if(!checkNullAndSize(user.getName() , 3 , 256)) return null;
        if(!checkNullAndSize(user.getPassword() , 3 , 128)) return null;
        if(!checkNullAndSize(user.getNationality() , 3 , 64)) return null;

        return user;
    }

    private Boolean checkNullAndSize(String string, int min, int max) {
        return string != null && !((string.length() < min) || (string.length() > max));
    }

    private User mapUser(HttpServletRequest request, Set<UserProfile> userProfiles){
        String email, password, name, address, nationality;
        int postal1, postal2;
        int day_birth, month_birth, year_birth;
        Date birth;

        try {
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

            birth = dateConversion(year_birth, month_birth, day_birth);

            return new User()
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
                    .setState(State.INACTIVE.getState())
                    .setUserProfiles(userProfiles);
        }catch (NumberFormatException exception){
            new Logger().err_log("Number Format Exception: LoginMenuController.Java Line 63");
        }


        return null;
    }

    private Boolean hasAllValues(HttpServletRequest request){
        Map<String, String[]> parameters = request.getParameterMap();

        return (parameters.containsKey("email")         &&
                parameters.containsKey("password")      &&
                parameters.containsKey("name")          &&
                parameters.containsKey("address")       &&
                parameters.containsKey("dia_reg")       &&
                parameters.containsKey("mes_reg")       &&
                parameters.containsKey("ano_reg")       &&
                parameters.containsKey("nationality")   &&
                parameters.containsKey("postal1")       &&
                parameters.containsKey("postal2"));

    }

    private Date dateConversion(int year, int month, int day){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);

        return cal.getTime();
    }
}
