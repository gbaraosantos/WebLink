package com.weblink.core.validators;


import com.weblink.core.models.Action;
import com.weblink.core.models.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CourseFilterValidator {
    public HashMap<String,String> validateInput(HttpServletRequest request, User user) {
        if (!hasAllValues(request,user)) return null;

        HashMap<String,String> result = new HashMap<>();


        checkForArea(request, result);
        checkforName(request,result);
        checkforDate(request, result);
        checkforisVisible(request, result);
        checkForMaxPrice(request,result);
        checkForCreatedBy(request, result, user);



        return result;

    }

    private void checkForCreatedBy(HttpServletRequest request, HashMap<String, String> result, User user) {
        String createdBy = request.getParameter("createdBy");

        if(createdBy.equals("any")) return;

        result.put("id", String.valueOf(user.getId()));

    }

    private void checkForMaxPrice(HttpServletRequest request, HashMap<String, String> result) {
        String price = request.getParameter("pricerangeValue");
        result.put("finalPrice",price);
    }

    private void checkforisVisible(HttpServletRequest request, HashMap<String, String> result) {
        String visible = request.getParameter("isvisible");
        if(visible.equals("any")) return;
        result.put("visible",visible);
    }

    private  void checkforDate(HttpServletRequest request, HashMap<String, String> result) {
        String date = request.getParameter("date");
        if(checkNullAndSize(date,1,100))
            result.put("startDate",date);
    }

    private void checkforName(HttpServletRequest request, HashMap<String, String> result) {
        String name = request.getParameter("name");
        if(checkNullAndSize(name,3,256))    result.put("name",name);
    }

    private void checkForArea(HttpServletRequest request, HashMap<String, String> result) {
        String area = request.getParameter("area");
        if(checkNullAndSize(area,3,256))    result.put("area",area);
    }


    private boolean checkNullAndSize(String string, int min, int max) {
        return string != null && !((string.length() < min) || (string.length() > max));
    }


    private boolean hasAllValues(HttpServletRequest request, User user) {
        Map<String, String[]> parameters = request.getParameterMap();

        if (user.hasPermission("Coordinator"))
            return (    parameters.containsKey("name")              &&
                        parameters.containsKey("area")              &&
                        parameters.containsKey("pricerangeValue")   &&
                        parameters.containsKey("date")              &&
                        parameters.containsKey("isvisible")         &&
                        parameters.containsKey("createdBy")         );

        else
            return (    parameters.containsKey("name")              &&
                        parameters.containsKey("area")              &&
                        parameters.containsKey("pricerangeValue")   &&
                        parameters.containsKey("date")              );


    }

}
