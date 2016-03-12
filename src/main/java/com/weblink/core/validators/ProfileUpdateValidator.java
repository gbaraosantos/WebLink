package com.weblink.core.validators;


import com.weblink.core.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ProfileUpdateValidator {

    public User validateInput(HttpServletRequest request, User user , PasswordEncoder passwordEncoder) {
        if(!hasAllValues(request)) return user;

        user = has_email(request,user);
        user = has_password(request,user,passwordEncoder);
        user = has_name(request,user);
        user = has_address(request,user);
        user = has_nationality(request,user);
        user = has_postal1(request,user);
        user = has_postal2(request,user);

        return user;

    }


    public User has_email(HttpServletRequest request, User user){
        String email = request.getParameter("email");
        if (checkNullAndSize(email, 3 , 128)) user.setEmail(email);
        return user;
    }

    public User has_password(HttpServletRequest request, User user,PasswordEncoder passwordEncoder){
        String password = request.getParameter("password");
        if (checkNullAndSize(password, 6 , 128)) user.setPassword(passwordEncoder.encode(password));
        return user;
    }

    public User has_name(HttpServletRequest request, User user){
        String name = request.getParameter("nome");
        if (checkNullAndSize(name, 3 , 256)) user.setName(name);
        return user;
    }

    public User has_address(HttpServletRequest request, User user){
        String addr = request.getParameter("morada");
        if (checkNullAndSize(addr, 3 , 256)) user.setAddress(addr);
        return user;
    }

    public User has_nationality(HttpServletRequest request, User user){
        String nat = request.getParameter("nacionalidade");
        if (checkNullAndSize(nat, 3 , 256)) user.setNationality(nat);
        return user;
    }

    public User has_postal1(HttpServletRequest request, User user){
        try{
            String postal1 = request.getParameter("postal1");
            if (checkNull(postal1)){
                user.setPostal1(Integer.parseInt(postal1));
            }
            return user;
        }catch (NumberFormatException exception){
            System.out.println("Number Format Exception: LoginMenuController.Java Line 63");
            return user;
        }
    }

    public User has_postal2(HttpServletRequest request, User user){
        try{
            String postal2 = request.getParameter("postal2");
            if (checkNull(postal2)){
                user.setPostal2(Integer.parseInt(postal2));
            }
            return user;
        }catch (NumberFormatException exception){
            System.out.println("Number Format Exception: LoginMenuController.Java Line 63");
            return user;
        }
    }


    private Boolean checkNull(String string) {
        return string != null;
    }


    private Boolean checkNullAndSize(String string, int min, int max) {
        return string != null && !((string.length() < min) || (string.length() > max));
    }


    private Boolean hasAllValues(HttpServletRequest request){
        Map<String, String[]> parameters = request.getParameterMap();

        return (parameters.containsKey("email")         &&
                parameters.containsKey("password")      &&
                parameters.containsKey("nome")          &&
                parameters.containsKey("morada")       &&
                parameters.containsKey("nacionalidade")   &&
                parameters.containsKey("postal1")       &&
                parameters.containsKey("postal2"));

    }
}
