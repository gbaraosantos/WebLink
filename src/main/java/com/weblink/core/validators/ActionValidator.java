package com.weblink.core.validators;

import com.weblink.core.models.Action;
import com.weblink.core.models.Course;
import com.weblink.core.models.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ActionValidator {
    public Action validateInput(HttpServletRequest request, Course course, User user) {
        if (!hasAllValues(request)) return null;

        Action action = mapAction(request, course, user);


        if (action == null) return null;
        if(!min(action.getDiscount() , 0)) return null;
        if(action.getStartDate().before(new Date()))    return null;
        return action;
    }

    private boolean min(int price, int i) {
        return price >= i;
    }

    private Action mapAction(HttpServletRequest request, Course course, User user) {
        int discount;

        SimpleDateFormat sdfmt1 = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date startDate = sdfmt1.parse(request.getParameter("startDateAction"));
            discount = Integer.parseInt(request.getParameter("discount"));

            return new Action()
                    .setCreationDate(new Date())
                    .setLastChangeDate(new Date())
                    .setCourse(course)
                    .setDiscount(discount)
                    .setEndDate(null)
                    .setVisible(false)
                    .setStartDate(startDate)
                    .setCreatedBy(user);
        } catch (ParseException e) {
            return null;
        }

    }

    private boolean hasAllValues(HttpServletRequest request) {
        Map<String, String[]> parameters = request.getParameterMap();

        return (parameters.containsKey("CourseID")                  &&
                parameters.containsKey("startDateAction")           &&
                parameters.containsKey("discount"));
    }
}
