package com.weblink.core.validators;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class EmailInputValidator {
    public String EmailValidator(HttpServletRequest request) {
        String email;

        if(!hasAllValues(request)) return null;
        email = mapEmail(request);

        if(email == null) return null;
        if(!checkNullAndSize(email , 3 , 128)) return null;

        return email;
    }

    private boolean checkNullAndSize(String string, int min, int max) {
        return string != null && !((string.length() < min) || (string.length() > max));
    }

    private String mapEmail(HttpServletRequest request) {
        return request.getParameter("email");
    }

    private boolean hasAllValues(HttpServletRequest request) {
        Map<String, String[]> parameters = request.getParameterMap();
        return parameters.containsKey("email");
    }

}
