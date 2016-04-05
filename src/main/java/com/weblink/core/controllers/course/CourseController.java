package com.weblink.core.controllers.course;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weblink.core.common.enums.EvaluationType;
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
import com.weblink.core.validators.CourseFilterValidator;
import com.weblink.core.validators.CourseValidator;
import com.weblink.core.validators.ModuleValidator;
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

        Map<String, Object> log = new HashMap<>();
        log.put("ip" , request.getRemoteAddr());
        log.put("createdBy" , getEmail());
        log.put("type" , "Course Creation");
        log.put("Course Name" , action.getCourse().getName());
        log.put("Course Area" , action.getCourse().getArea());
        logger.log(log, "INFO");


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

            Map<String, Object> log = new HashMap<>();
            log.put("ip" , request.getRemoteAddr());
            log.put("createdBy" , getEmail());
            log.put("type" , "Action Creation");
            log.put("Course Name" , action.getCourse().getName());
            log.put("Start Date" , action.getStartDate());
            logger.log(log, "INFO");


            return "redirect:/weblink/courses?addCourse=true";

        }catch (Exception e){
            Map<String, Object> log = new HashMap<>();
            log.put("ip" , request.getRemoteAddr());
            log.put("createdBy" , getEmail());
            log.put("type" , "Action Creation");
            logger.log(log, "ERROR");



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
        if(action != null){
            actionManagementService.deleteAction(action);

            Map<String, Object> log = new HashMap<>();
            log.put("DeletedBy" , getEmail());
            log.put("type" , "Action Delete");
            log.put("Course Name" , action.getCourse().getName());
            log.put("Start Date" , action.getStartDate());
            logger.log(log, "INFO");

        }

    }

    @RequestMapping(value = "/coord/changeVisibility" , method = RequestMethod.GET, params = {"Action"})
    public String changeVisibility(@RequestParam("Action") int id, Model model){
        prepareModel(model);

        Action action = actionManagementService.getAction(id);
        if (action != null){
            actionManagementService.updateAction(action.changeVisibility());

            Map<String, Object> log = new HashMap<>();
            log.put("ChangedBy" , getEmail());
            log.put("type" , "VisibilityChange");
            log.put("Course Name" , action.getCourse().getName());
            log.put("Start Date" , action.getStartDate());
            logger.log(log, "INFO");

        }
        return "redirect:/weblink/courses";
    }

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
            temp.put("creationDate", String.valueOf(module.getCreationDate()));
            temp.put("lastChangeDate", String.valueOf(module.getLastChangeDate()));
            temp.put("percentage", String.valueOf(module.getPercentage()));


            map.add(temp);

        }

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(map);
        return result;
    }

    @RequestMapping(value="/coord/addModule", method = RequestMethod.POST)
    public String moduleCreate(HttpServletRequest request, Model model) {
        int position = 0;
        prepareModel(model);

        Course course = courseManagementService.getCourse(Integer.parseInt(request.getParameter("courseIdModule")));
        if(course == null) return "redirect:/coord/addModule?addModule=false";

        List<Module> moduleList= moduleManagementService.getCourseModules(course);
        if(moduleList == null) return "redirect:/coord/addModule?addModule=false";

        for(Module m : moduleList){
            if(m.getPosition() > position)  position = m.getPosition();
        }

        Module module = new ModuleValidator().validateInput(request, user, course,null, position+1);
        if (module == null)  return "redirect:/coord/addModule?addModule=false";

        Map<String, Object> log = new HashMap<>();
        log.put("ip" , request.getRemoteAddr());
        log.put("CreatedBy" , getEmail());
        log.put("type" , "Module Creation");
        log.put("Course Name" , module.getCourse().getName());
        log.put("Module Name" , module.getName());
        log.put("Percentage" , module.getPercentage());
        logger.log(log, "INFO");

        moduleManagementService.addModule(module);
        return "redirect:/coord/addModule?addModule=true";
    }

    @RequestMapping(value="/coord/updateModule", method = RequestMethod.POST, params = {"module"})
    public String updateModule(@RequestParam("module") int  moduleId, Model model, HttpServletRequest request) {
        prepareModel(model);

        Module module = moduleManagementService.getModule(moduleId);
        if (module == null) return "redirect:/coord/addModule?addModule=false";

        Module moduleToUpdate = new ModuleValidator().validateInput(request, user, module.getCourse() ,module, module.getPosition());
        if(moduleToUpdate == null) return "redirect:/coord/addModule?addModule=false";

        Map<String, Object> log = new HashMap<>();
        log.put("ip" , request.getRemoteAddr());
        log.put("UpdatedBy" , getEmail());
        log.put("type" , "Module Update");
        log.put("Course Name" , moduleToUpdate.getCourse().getName());
        log.put("Module Name" , moduleToUpdate.getName());
        log.put("Percentage" , moduleToUpdate.getPercentage());
        logger.log(log, "INFO");

        moduleManagementService.updateModule(moduleToUpdate);
        return "redirect:/coord/addModule?addModule=true";
    }

    @RequestMapping(value="/coord/addModule", method = RequestMethod.GET, params = {"addModule"})
    public String moduleCreationFail(@RequestParam("addModule") boolean addModule, Model model) {
        prepareModel(model);

        if(addModule)   model.addAttribute("SuccessCreating", "Sucesso a Adicionar/Alterar Modulo");
        else{
            model.addAttribute("FailureCreating", "Criação/Alteração de Modulo não foi bem sucedida");

            Map<String, Object> log = new HashMap<>();
            log.put("CreatedBy" , getEmail());
            log.put("type" , "Module Creation Failure");
            logger.log(log, "ERROR");


        }

        return "Courses";
    }

    @RequestMapping(value = "/coord/ChangeUp" , method = RequestMethod.GET, params = {"module"})
    public @ResponseBody String changeModuleUp(@RequestParam("module") int id, Model model, HttpServletResponse response) throws IOException {
        prepareModel(model);

        Module module = moduleManagementService.getModule(id);

        if (module == null)             return "Could Not Change";
        if (module.getPosition() <= 1)  return "Could Not Change";

        Module module2 = moduleManagementService.getModule(module.getCourse(), module.getPosition() - 1);
        if(module2 == null)             return "Could Not Change";

        Map<String, Object> log = new HashMap<>();
        log.put("CreatedBy" , getEmail());
        log.put("type" , "Module Position Change");
        log.put("Module 1 Name" , module.getName());
        log.put("Module 2 Name" , module2.getName());
        logger.log(log, "INFO");


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

        Map<String, Object> log = new HashMap<>();
        log.put("CreatedBy" , getEmail());
        log.put("type" , "Module Position Change");
        log.put("Module 1 Name" , module.getName());
        log.put("Module 2 Name" , module2.getName());
        logger.log(log, "INFO");

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

        Map<String, Object> log = new HashMap<>();
        log.put("DeletedBy" , getEmail());
        log.put("type" , "Module Delete");
        log.put("Course Name" , module.getCourse().getName());
        log.put("Module Name" , module.getName());
        log.put("Percentage" , module.getPercentage());
        logger.log(log, "INFO");

        return "Deleted";
    }

    @RequestMapping(value = "/weblink/filterCourse" , method = RequestMethod.POST)
    public String filterCourses(Model model, HttpServletRequest request){
        user = userService.getSingleUser(getEmail());
        model.addAttribute("evalTypes" , EvaluationType.getAll());
        model.addAttribute("User", user);
        model.addAttribute("courses" , courseManagementService.getAll());

        Map<String,String> filterRequest = new CourseFilterValidator().validateInput(request,user);
        List<Action> result = actionManagementService.getFiltered(filterRequest);

        if(result == null){
            model.addAttribute("NoActions","Não Existem Cursos que correspondam a essa pesquisa.");
            return "Courses";
        }

        checkIfAnyVisible(result, model);
        return "Courses";
    }

    private Model prepareModel(Model model){
        user = userService.getSingleUser(getEmail());
        model.addAttribute("User", user);
        model.addAttribute("evalTypes" , EvaluationType.getAll());
        model.addAttribute("courses" , courseManagementService.getAll());
        model = noVisibleAction(model);
        return model;
    }

    private Model checkIfAnyVisible(List<Action> actions, Model model){
        Boolean errorShow = true;

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

    private Model noVisibleAction(Model model){

        List<Action> actions = actionManagementService.getUpcoming();
        return checkIfAnyVisible(actions,model);

    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
