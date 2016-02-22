package com.weblink.core.validators;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public class PasswordResetValidator {
    public String passwordResetValidator(HttpServletRequest request) {
        String password;

        if(!hasAllValues(request)) return null;
        password = mapPassword(request);

        if(password == null) return null;
        if(!checkNullAndSize(password , 3 , 128)) return null;

        return password;
    }

    private String mapPassword(HttpServletRequest request) {
        String pass1, pass2;
        pass1 = request.getParameter("password");
        pass2 = request.getParameter("password_again");

        if(!pass1.equals(pass2)) return null;
        return pass1;

    }

    private boolean checkNullAndSize(String string, int min, int max) {
        return string != null && !((string.length() < min) || (string.length() > max));
    }


    private boolean hasAllValues(HttpServletRequest request) {
        Map<String, String[]> parameters = request.getParameterMap();
        return parameters.containsKey("password") && parameters.containsKey("password_again");
    }
}
