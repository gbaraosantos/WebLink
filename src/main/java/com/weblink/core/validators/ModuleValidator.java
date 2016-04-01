package com.weblink.core.validators;


import com.weblink.core.models.Action;
import com.weblink.core.models.Course;
import com.weblink.core.models.Module;
import com.weblink.core.models.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

public class ModuleValidator {
    public Module validateInput(HttpServletRequest request, User user, Course course, Module thisIsTheOne, int position) {
        if (!hasAllValues(request)) return null;

        Module module = mapModule(request, user, course, position, thisIsTheOne);
        if(module == null) return null;

        if(!checkNullAndSize(module.getName() , 3 , 256)) return null;
        if(!checkNullAndSize(module.getDescription() , 6 , 2560)) return null;
        if(!min(module.getPercentage() , 1)) return null;
        return module;

    }

    private boolean min(int numberModules, int i) {
        return numberModules >= i;
    }



    private boolean checkNullAndSize(String string, int min, int max) {
        return string != null && !((string.length() < min) || (string.length() > max));
    }

    private Module mapModule(HttpServletRequest request, User user, Course course, int position, Module thisIsTheOne) {
        String moduleDescription, moduleName;
        Integer percentage;

        try {
            Module module = new Module();


            moduleDescription = request.getParameter("moduleDescription");
            moduleName = request.getParameter("moduleName");
            percentage = Integer.parseInt(request.getParameter("percentage"));

            if(thisIsTheOne == null){
                module  .setCourse(course)
                        .setCreationDate(new Date())
                        .setDescription(moduleDescription)
                        .setLastChangeDate(new Date())
                        .setPercentage(percentage)
                        .setPosition(position)
                        .setName(moduleName)
                        .setCreatedBy(user);

                return module;
            }

            thisIsTheOne.setName(moduleName)
                        .setLastChangeDate(new Date())
                        .setDescription(moduleDescription)
                        .setPercentage(percentage);
            return thisIsTheOne;

        }catch (Exception exception){ System.out.println("Exception adding a new course "); }
        return null;


    }

    private Boolean hasAllValues(HttpServletRequest request){
        Map<String, String[]> parameters = request.getParameterMap();

        return (parameters.containsKey("percentage")            &&
                parameters.containsKey("moduleDescription")     &&
                parameters.containsKey("moduleName"));

    }


  /*  public Module validateInput(HttpServletRequest request, User user, Boolean add) {



    }


*/
}
