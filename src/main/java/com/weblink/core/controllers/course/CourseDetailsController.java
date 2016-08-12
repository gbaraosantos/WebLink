package com.weblink.core.controllers.course;


import com.weblink.core.common.enums.UserProfileType;
import com.weblink.core.models.*;
import com.weblink.core.services.course_management_service.ActionManagementService;
import com.weblink.core.services.course_management_service.CourseManagementService;
import com.weblink.core.services.course_management_service.ModuleManagementService;
import com.weblink.core.services.logger_service.LoggerService;
import com.weblink.core.services.messaging_service.MessageService;
import com.weblink.core.services.module_action_management_service.ModuleActionManagementService;
import com.weblink.core.services.student_management_service.StudentMPAService;
import com.weblink.core.services.student_management_service.StudentManagementService;
import com.weblink.core.services.teacher_management_service.TeacherManagementService;
import com.weblink.core.services.user_service.FriendService;
import com.weblink.core.services.user_service.UserService;
import com.weblink.core.validators.ModuleValidator;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class CourseDetailsController {
    @Autowired  UserService userService;
    @Autowired  LoggerService logger;
    @Autowired  CourseManagementService courseManagementService;
    @Autowired  ActionManagementService actionManagementService;
    @Autowired  ModuleManagementService moduleManagementService;
    @Autowired  ModuleActionManagementService moduleActionManagementService;
    @Autowired  TeacherManagementService teacherManagementService;
    @Autowired  StudentManagementService studentManagementService;
    @Autowired  MessageService messageService;
    @Autowired  FriendService friendService;
    @Autowired  StudentMPAService studentMPAService;

    private volatile User user;


    @RequestMapping(value = "/weblink/action", method = RequestMethod.GET, params = {"action"})
    public String actionPage(@RequestParam("action") int actionId, Model model) {
        prepareModel(model, actionId);


        return "CourseDetails";
    }

    @RequestMapping(value = "/coord/addTeacher", method = RequestMethod.POST)
    private String addTeacher(Model model, HttpServletRequest request){
        try{
            String [] users = request.getParameterValues("teacherList[]");

            int MpaId = Integer.parseInt(request.getParameter("MpaId"));
            ModulePerAction modulePerAction = moduleActionManagementService.getMpa(MpaId);

            if(users == null || modulePerAction == null)   return "redirect:" + request.getHeader("Referer") + "&ErrorAddTeach=5";


            for(String u : users){
                User user = userService.getSingleUser(Integer.parseInt(u));


                teacherManagementService.addTeacher(new Teacher()
                        .setTeacher(user)
                        .setModulePerAction(modulePerAction));


                Map<String, Object> log = new HashMap<>();
                log.put("AddedBy" , getEmail());
                log.put("type" , "Teacher add");
                log.put("Action" , modulePerAction.getAction().getId());
                log.put("Module" , modulePerAction.getModule().getId());
                log.put("Email" , user.getEmail());
                logger.log(log, "INFO");
            }

            return "redirect:" + request.getHeader("Referer") + "&ErrorAddTeach=false";

        }catch (Exception e){ return "redirect:" + request.getHeader("Referer") + "&ErrorAddTeach=true"; }
    }

    @RequestMapping(value = "/coord/deleteTeacher" , method = RequestMethod.GET, params = {"teacherId"})
    public @ResponseBody String deleteTeacher(@RequestParam("teacherId") int id, Model model, HttpServletResponse response) throws IOException {
        Teacher teach = teacherManagementService.getTeacher(id);
        if (teach == null) return "Could not delete";

        teacherManagementService.deleteTeacher(teach);


        Map<String, Object> log = new HashMap<>();
        log.put("DeletedBy" , getEmail());
        log.put("type" , "Teacher Delete");
        log.put("Action" , teach.getModulePerAction().getAction().getId());
        log.put("Module" , teach.getModulePerAction().getModule().getId());
        log.put("Email" , teach.getTeacher().getEmail());
        logger.log(log, "INFO");

        return "Deleted";
    }

    @RequestMapping(value = "/coord/editMpa", method = RequestMethod.POST)
    private String editMpa(Model model, HttpServletRequest request){
        Date startDate, endDate;


        try{
            int MpaId = Integer.parseInt(request.getParameter("MpaId"));
            ModulePerAction modulePerAction = moduleActionManagementService.getMpa(MpaId);

            if(modulePerAction == null)   return "redirect:" + request.getHeader("Referer") + "&ErrorEdtingMpa=2";

            SimpleDateFormat sdfmt1 = new SimpleDateFormat("yyyy-MM-dd");
            startDate = sdfmt1.parse(request.getParameter("startMPA"));
            endDate   = sdfmt1.parse(request.getParameter("endMPA"));

            Module module = new ModuleValidator().validateInput(request,
                    user,
                    modulePerAction.getAction().getCourse(),
                    modulePerAction.getModule(),
                    modulePerAction.getModule().getPosition()
            );


            if(module == null)  return "redirect:" + request.getHeader("Referer") + "&ErrorEdtingMpa=1";
            if(startDate.before(modulePerAction.getAction().getStartDate()))  return "redirect:" + request.getHeader("Referer") + "&ErrorEdtingMpa=1";
            if(endDate.before(startDate))    return "redirect:" + request.getHeader("Referer") + "&ErrorEdtingMpa=4";

            modulePerAction.setStartDate(startDate)
                            .setEndDate(endDate);

            moduleActionManagementService.updateModulePerAction(modulePerAction);
            moduleManagementService.updateModule(module);

            Map<String, Object> log = new HashMap<>();
            log.put("EditedBy" , getEmail());
            log.put("type" , "MPA Edit");
            log.put("Action" , modulePerAction.getAction().getId());
            log.put("Module" , modulePerAction.getModule().getId());
            log.put("startDate" , modulePerAction.getStartDate());
            log.put("endDate" , modulePerAction.getEndDate());
            logger.log(log, "INFO");


            return "redirect:" + request.getHeader("Referer") + "&ErrorEdtingMpa=0";

        }catch (Exception e){
            e.printStackTrace();
            return "redirect:" + request.getHeader("Referer") + "&ErrorEdtingMpa=3";
        }
    }

    @RequestMapping(value="/weblink/action", method = RequestMethod.GET, params = {"action" , "ErrorEdtingMpa"})
    public String editMpaFail(@RequestParam("ErrorEdtingMpa") int cause , @RequestParam("action") int action, Model model) {
        prepareModel(model,action);

        switch (cause){
            case(1):
                model.addAttribute("ErrorEdtingMpa" , "Module Start date cant come before the start of the action");
                return "CourseDetails";
            case(2):
                model.addAttribute("ErrorEdtingMpa" , "Could Not Edit Module - No such MPA");
                return "CourseDetails";
            case(3):
                model.addAttribute("ErrorEdtingMpa" , "Could Not Edit Module - Exception");
                return "CourseDetails";

            case(4):
                model.addAttribute("ErrorEdtingMpa", "Module can't end before it starts");
                return "CourseDetails";
            case(5):
                model.addAttribute("ErrorAddingTeacher", "No Teacher Was Selected");
                return "CourseDetails";

            default:
                return "CourseDetails";
        }

    }

    @RequestMapping(value = "/weblink/addStudent", method = RequestMethod.GET, params = {"action"})
    public String addStudent(@RequestParam("action") int actionId, Model model) {
        prepareModel(model, actionId);
        Action a = actionManagementService.getAction(actionId);

        if(a == null) return "CourseDetails";


        Student temp = new Student()
                .setAction(a)
                .setBuyDate(new Date())
                .setBuyPrice(a.getFinalPrice())
                .setFinalGrade(0)
                .setUser(user);

        studentManagementService.addStudent(temp);

        for (ModulePerAction mpa: a.getActionList()){
            studentMPAService.createStudentMPA(
                    new StudentMPA()
                                .setStudent(studentManagementService.getStudent(a, user))
                                .setModuleGrade(0)
                                .setModulePerAction(mpa)


            );
        }


        return "CourseDetails";
    }



    private void prepareModel(Model model, int actionId) {
        Action a = actionManagementService.getAction(actionId);
        List<ModulePerAction> list = moduleActionManagementService.getMpa(a);
        List<User> listUser = userService.getWithPermission(UserProfileType.TEACHER.getUserProfileType());

        List<FriendRequest> list1 = friendService.getToMePending(user);
        List<EmailApp> sentList = messageService.sentMessages(user);
        List<EmailApp> receivedList = messageService.receivedMessage(user);
        List<EmailApp> receivedUnreadList = messageService.receivedUnreadMessage(user);

        model.addAttribute("fromMePending", friendService.getFromMePending(user));
        model.addAttribute("toMePending", list1 );
        model.addAttribute("friendListing" , friendService.getFriends(user));
        model.addAttribute("sentList" , sentList);
        model.addAttribute("receivedList", receivedList);

        if(list1 != null) model.addAttribute("nrRequestsPending" , list1.size());
        if(receivedUnreadList != null) model.addAttribute("nrMessages", receivedUnreadList.size());


        user = userService.getSingleUser(getEmail());
        model.addAttribute("User", user);
        model.addAttribute("action" , a);

        if(listUser != null) model.addAttribute("listPossibleTeachers" , listUser);


        if(list == null){
            model.addAttribute("noMPA", "Não Existem Módulos para esta acção");
        }
        else{
            model.addAttribute("MPAList", list);
        }


    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
