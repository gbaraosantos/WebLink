package com.weblink.core.validators;


import com.weblink.core.common.enums.CourseType;
import com.weblink.core.models.Action;
import com.weblink.core.models.Course;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class CourseValidator {
    public Action validateInput(HttpServletRequest request) {
        if (!hasAllValues(request)) return null;

        Action action = mapAction(request);
        if(action == null) return null;


        Course course = action.getCourse();
        if(course == null) return null;


        if(action.getStartDate().before(new Date()))    return null;
        if(!checkNullAndSize(course.getName() , 3 , 256)) return null;
        if(!checkNullAndSize(course.getArea() , 3 , 256)) return null;
        if(!checkNullAndSize(course.getIcon() , 1 , 64)) return null;
        if(!checkNullAndSize(course.getDescription() , 6 , 2048)) return null;
        if(!min(course.getNumberModules() , 1)) return null;
        if(!min(course.getReTryPrice() , 0)) return null;
        if(!min(course.getPrice() , 0)) return null;
        if(!min(course.getNumClasses() , 0)) return null;

        return action;


    }

    private boolean min(int numberModules, int i) {
        return numberModules >= i;
    }



    private boolean checkNullAndSize(String string, int min, int max) {
        return string != null && !((string.length() < min) || (string.length() > max));
    }


    private Action mapAction(HttpServletRequest request) {
        SimpleDateFormat sdfmt1 = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date startDate = sdfmt1.parse(request.getParameter("startDate"));

            return new Action()
                    .setCreationDate(new Date())
                    .setLastChangeDate(new Date())
                    .setCourse(mapCourse(request))
                    .setDiscount(0)
                    .setEndDate(null)
                    .setVisible(false)
                    .setStartDate(startDate);
        } catch (ParseException e) {
            return null;
        }


    }

    private Course mapCourse(HttpServletRequest request) {
        String area, courseName, description, icon;
        Integer nModules, price, nClasses, tClass, optionsRadios;

        try {
            area = request.getParameter("area");
            courseName = request.getParameter("courseName");
            description = request.getParameter("description");
            nModules = Integer.parseInt(request.getParameter("nModules"));
            optionsRadios = Integer.parseInt(request.getParameter("optionsRadios"));
            icon = request.getParameter("IconSelect");
            price = Integer.parseInt(request.getParameter("price"));
            nClasses = Integer.parseInt(request.getParameter("nClasses"));
            tClass = Integer.parseInt(request.getParameter("tClass"));

            String courseType = getCourseType(optionsRadios);
            Double retryPrice = 0.25 * price;


            return new Course()
                    .setArea(area)
                    .setName(courseName)
                    .setDescription(description)
                    .setNumberModules(nModules)
                    .setSynch(courseType)
                    .setIcon(icon)
                    .setCreationDate(new Date())
                    .setLastChangeDate(new Date())
                    .setPrice(price)
                    .setNumClasses(nClasses)
                    .settClass(tClass)
                    .setReTryPrice(retryPrice.intValue());


        }catch (Exception exception){ System.out.println("Exception adding a new course "); }
        return null;



    }

    private String getCourseType(Integer optionsRadios) {
        switch (optionsRadios){
            case(1):    return CourseType.SYNCHRONOUS.getCourseType();
            case(2):    return CourseType.ASYNCHRONOUS.getCourseType();
            case(3):    return CourseType.BLENDED.getCourseType();
            default:    return CourseType.SYNCHRONOUS.getCourseType();

        }
    }

    private Boolean hasAllValues(HttpServletRequest request){
        Map<String, String[]> parameters = request.getParameterMap();

        return (parameters.containsKey("area")              &&
                parameters.containsKey("courseName")        &&
                parameters.containsKey("description")       &&
                parameters.containsKey("nModules")          &&
                parameters.containsKey("optionsRadios")     &&
                parameters.containsKey("IconSelect")        &&
                parameters.containsKey("startDate")         &&
                parameters.containsKey("price")             &&
                parameters.containsKey("nClasses")          &&
                parameters.containsKey("tClass"));

    }

}
