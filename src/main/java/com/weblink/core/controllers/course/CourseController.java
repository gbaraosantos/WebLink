package com.weblink.core.controllers.course;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weblink.core.models.Action;
import com.weblink.core.models.Course;
import com.weblink.core.models.Module;
import com.weblink.core.models.User;
import com.weblink.core.services.course_management_service.ActionManagementService;
import com.weblink.core.services.course_management_service.CourseManagementService;
import com.weblink.core.services.course_management_service.ModuleManagementService;
import com.weblink.core.services.logger_service.LoggerService;
import com.weblink.core.services.user_service.UserService;
import com.weblink.core.validators.ActionValidator;
import com.weblink.core.validators.CourseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class CourseController {

    @Autowired UserService userService;
    @Autowired LoggerService logger;
    @Autowired CourseManagementService courseManagementService;
    @Autowired ActionManagementService actionManagementService;
    @Autowired ModuleManagementService moduleManagementService;

    private volatile User user;

    @RequestMapping(value = "/weblink/courses", method = RequestMethod.GET)
    public String getCourses(Model model){
        prepareModel(model);
        return "Courses";
    }

    @RequestMapping(value = "/coord/addCourse" , method = RequestMethod.POST)
    public String getCourseAdd(Model model, HttpServletRequest request){
        prepareModel(model);

        Action action = new CourseValidator().validateInput(request, user);

        if (action == null)  return "redirect:/weblink/courses?addCourse=false";

        courseManagementService.createCourse(action.getCourse());
        actionManagementService.createAction(action.setCourse(courseManagementService.getCourse(action.getCourse().getName())));

        return "redirect:/weblink/courses?addCourse=true";
    }

    @RequestMapping(value = "/coord/addAction" , method = RequestMethod.POST)
    public String getActionAdd(Model model, HttpServletRequest request){

        prepareModel(model);
        try{
            Course course = courseManagementService.getCourse(Integer.parseInt(request.getParameter("CourseID")));
            if(course == null) return "redirect:/weblink/courses?addCourse=false";

            Action action = new ActionValidator().validateInput(request, course, user);
            if (action == null)  return "redirect:/weblink/courses?addCourse=false";

            actionManagementService.createAction(action);
            return "redirect:/weblink/courses?addCourse=true";

        }catch (Exception e){
            return "redirect:/weblink/courses?addCourse=false";
        }

    }

    @RequestMapping(value="/weblink/courses", method = RequestMethod.GET, params = {"addCourse"})
    public String courseCreationFail(@RequestParam("addCourse") boolean addCourse, Model model) {
        prepareModel(model);

        if(addCourse)   model.addAttribute("SuccessCreating", "Sucesso a Adicionar Curso/Accao");
        else            model.addAttribute("FailureCreating", "Criação de Curso/Accao não foi bem sucedida");

        return "Courses";
    }

    @RequestMapping(value="/coord/deleteAction", method = RequestMethod.GET, params = {"Action"})
    public void deleteAction(@RequestParam("Action") int id, Model model) {
        prepareModel(model);

        Action action = actionManagementService.getAction(id);
        if(action != null) actionManagementService.deleteAction(action);

    }



    @RequestMapping(value = "/coord/changeVisibility" , method = RequestMethod.GET, params = {"Action"})
    public String changeVisibility(@RequestParam("Action") int id, Model model){
        prepareModel(model);

        Action action = actionManagementService.getAction(id);
        if (action != null) actionManagementService.updateAction(action.changeVisibility());
        return "redirect:/weblink/courses";
    }

    /*This is a comment*/

    @RequestMapping(value = "/coord/getModules" , method = RequestMethod.GET, params = {"Course"})
    public @ResponseBody String getCourseModules(@RequestParam("Course") int id, Model model, HttpServletResponse response) throws IOException {
        List<Map<String, String>> map = new LinkedList<>();

        prepareModel(model);
        Course course = courseManagementService.getCourse(id);

        if(course == null)  return null;

        List<Module> moduleList = moduleManagementService.getCourseModules(course);

        for(Module module: moduleList){
            Map<String, String> temp = new HashMap<>();

            temp.put("id" , String.valueOf(module.getId()));
            temp.put("pos" , String.valueOf(module.getPosition()));
            temp.put("name" , module.getName());
            temp.put("description" , module.getDescription());
            temp.put("startDate", String.valueOf(module.getStartDate()));
            temp.put("endDate", String.valueOf(module.getEndDate()));
            temp.put("nClasses", String.valueOf(module.getnClasses()));
            temp.put("percentage", String.valueOf(module.getPercentage()));


            map.add(temp);

        }

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(map);
        System.out.println(result);
        return result;
    }

    @RequestMapping(value = "/coord/ChangeUp" , method = RequestMethod.GET, params = {"module"})
    public @ResponseBody String changeModuleUp(@RequestParam("module") int id, Model model, HttpServletResponse response) throws IOException {
        prepareModel(model);

        Module module = moduleManagementService.getModule(id);

        if (module == null)             return "Could Not Change";
        if (module.getPosition() <= 1)  return "Could Not Change";

        Module module2 = moduleManagementService.getModule(module.getCourse(), module.getPosition() - 1);
        if(module2 == null)             return "Could Not Change";

        moduleManagementService.updateModule(module.setPosition(module.getPosition() - 1));
        moduleManagementService.updateModule(module2.setPosition(module2.getPosition() + 1));

        return "Changed Up";
    }

    @RequestMapping(value = "/coord/ChangeDown" , method = RequestMethod.GET, params = {"module"})
    public @ResponseBody String changeModuleDown(@RequestParam("module") int id, Model model, HttpServletResponse response) throws IOException {
        prepareModel(model);

        Module module = moduleManagementService.getModule(id);

        if (module == null)             return "Could Not Change";

        Module module2 = moduleManagementService.getModule(module.getCourse(), module.getPosition() + 1);
        if(module2 == null)             return "Could Not Change";

        moduleManagementService.updateModule(module.setPosition(module.getPosition() + 1));
        moduleManagementService.updateModule(module2.setPosition(module2.getPosition() - 1));

        return "Changed Down";
    }

    @RequestMapping(value = "/coord/deleteModuleTrigger" , method = RequestMethod.GET, params = {"module"})
    public @ResponseBody String deleteModuleTrigger(@RequestParam("module") int id, Model model, HttpServletResponse response) throws IOException {
        prepareModel(model);
        Module module = moduleManagementService.getModule(id);

        if (module == null) return "Could not delete";
        moduleManagementService.deleteModule(module);


        return "Deleted";
    }

    private Model prepareModel(Model model){
        user = userService.getSingleUser(getEmail());
        model.addAttribute("User", user);
        model.addAttribute("courses" , courseManagementService.getAll());
        model = noVisibleAction(model);
        return model;
    }


    private Model noVisibleAction(Model model){
        Boolean errorShow = true;
        List<Action> actions = actionManagementService.getUpcoming();

        if(!user.hasPermission("Coordinator")){
            for(Action a : actions){
                if (a.isVisible()){
                    errorShow = false;
                    break;
                }
            }
        }else  if(actions.size() > 0)       errorShow = false;

        if (errorShow)      model.addAttribute("NoActions","Não Existem Cursos Disponiveis, Tente mais tarde.");

        model.addAttribute("actions" , actions);
        return model;
    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
