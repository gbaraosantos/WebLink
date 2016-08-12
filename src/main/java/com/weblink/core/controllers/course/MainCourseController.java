package com.weblink.core.controllers.course;

import com.weblink.core.common.enums.Extension;
import com.weblink.core.common.enums.FileType;
import com.weblink.core.common.file.FileBucket;
import com.weblink.core.models.*;
import com.weblink.core.services.course_management_service.ActionManagementService;
import com.weblink.core.services.evaluation.EvaluationService;
import com.weblink.core.services.file_system_service.FileSystemService;
import com.weblink.core.services.messaging_service.MessageService;
import com.weblink.core.services.module_action_management_service.ModuleActionManagementService;
import com.weblink.core.services.student_management_service.StudentManagementService;
import com.weblink.core.services.teacher_management_service.TeacherManagementService;
import com.weblink.core.services.user_service.FriendService;
import com.weblink.core.services.user_service.UserService;
import com.weblink.core.validators.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainCourseController {
    @Autowired UserService userService;
    @Autowired StudentManagementService studentManagementService;
    @Autowired ActionManagementService actionManagementService;
    @Autowired TeacherManagementService teacherManagementService;
    @Autowired ModuleActionManagementService moduleActionManagementService;
    @Autowired EvaluationService evaluationService;
    @Autowired FileSystemService fileSystemService;
    @Autowired private Environment environment;
    @Autowired MessageService messageService;
    @Autowired FriendService friendService;

    private volatile User user;

    @RequestMapping(value = "/weblink/inCourse", method = RequestMethod.GET, params = {"action"})
    public String actionPage(Model model, @RequestParam("action") int actionId) {
        prepareModel(model, actionId);
        return "inCourse";
    }

    @RequestMapping(value = "/teacher/deleteMaterial", method = RequestMethod.GET, params = {"actionId", "materialId"})
    public String addEvaluation(Model model,@RequestParam("actionId") int actionId, @RequestParam("materialId") int materialId){
        prepareModel(model, actionId);

        fileSystemService.deleteMaterial(materialId);
        return "redirect:/weblink/inCourse?action=" +actionId;
    }

    @RequestMapping(value = "/teacher/deleteEval", method = RequestMethod.GET, params = {"actionId", "evalId"})
    public String removeEval(Model model,@RequestParam("actionId") int actionId, @RequestParam("evalId") int evalId){
        prepareModel(model, actionId);

        evaluationService.removeEvaluation(evaluationService.getEvaluation(evalId));
        return "redirect:/weblink/inCourse?action=" +actionId;
    }

    @RequestMapping(value = "/teacher/addevaluation", method = RequestMethod.POST, params = {"actionId"})
    public String deleteMaterial(Model model,@RequestParam("actionId") int actionId, HttpServletRequest request){
        prepareModel(model, actionId);

        Action action = actionManagementService.getAction(actionId);
        ModulePerAction mpa = moduleActionManagementService.getCurrentModule(action);

        Evaluation e = new Evaluation();
        SimpleDateFormat sdfmt1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat teste = new SimpleDateFormat("hh:mm");

        try {
            Date startDate = sdfmt1.parse(request.getParameter("date"));
            Date teste12 = teste.parse(request.getParameter("time"));



            Date finalDate = new Date(
                    startDate.getYear(),
                    startDate.getMonth(),
                    startDate.getDate(),
                    teste12.getHours(),
                    teste12.getMinutes()
            );


            int type = Integer.parseInt(request.getParameter("optionsRadios"));

            if(type == 0)       e   .setClasss(false)
                                    .setCreationDate(new Date())
                                    .setDueDate(finalDate)
                                    .setEvaluated(true)
                                    .setModulePerAction(mpa);

            else                e   .setClasss(true)
                                    .setCreationDate(new Date())
                                    .setDueDate(finalDate)
                                    .setEvaluated(false)
                                    .setModulePerAction(mpa);

            evaluationService.addEvaluation(e);
        } catch (ParseException cxc) {
            cxc.printStackTrace();
        }

        return "redirect:/weblink/inCourse?action=" +actionId;
    }

    @RequestMapping(value = "/uploadMaterial", method = RequestMethod.POST, params = {"action"})
    public String uploadMaterial(@Valid FileBucket fileBucket, BindingResult result, Model model,@RequestParam("action") int actionId){
        prepareModel(model, actionId);
        if (result.hasErrors()) return "redirect:/weblink/inCourse?action=" +actionId + "&&uploadSuccess=false";

        Extension ext = new FileValidator().validateFile(fileBucket, FileType.ANY);
        if(ext == null) return "redirect:/weblink/inCourse?action=" +actionId + "&&uploadSuccess=false";

        Action action = actionManagementService.getAction(actionId);
        if(action == null)  return "redirect:/weblink/inCourse?action=" +actionId + "&&uploadSuccess=false";

        ModulePerAction mpa = moduleActionManagementService.getCurrentModule(action);
        if(mpa == null)  return "redirect:/weblink/inCourse?action=" +actionId + "&&uploadSuccess=false";

        if(!fileSystemService.createMaterial("Module",mpa.getModule(),"Teste","FileTeste",ext,fileBucket,user)) return "redirect:/weblink/inCourse?uploadSuccess=false";
        return "redirect:/weblink/inCourse?action=" +actionId + "&&uploadSuccess=true";

    }

    @RequestMapping(value = "/weblink/inCourse", method = RequestMethod.POST, params = {"action", "uploadSuccess"})
    public String uploadMaterialSuccess(Model model,@RequestParam("action") int actionId, @RequestParam("uploadSuccess") boolean uploadSuccess){
        prepareModel(model, actionId);

        if(uploadSuccess)   model.addAttribute("successUploading", "Success Uploading Material");
        model.addAttribute("someError", "Success Uploading Material");
        return "redirect:/weblink/inCourse?action=" +actionId;
    }

    private void prepareModel(Model model, int actionId) {
        model.addAttribute("fileBucket" , new FileBucket());
        user = userService.getSingleUser(getEmail());
        Action action = actionManagementService.getAction(actionId);

        List<FriendRequest> list = friendService.getToMePending(user);
        List<EmailApp> sentList = messageService.sentMessages(user);
        List<EmailApp> receivedList = messageService.receivedMessage(user);
        List<EmailApp> receivedUnreadList = messageService.receivedUnreadMessage(user);

        model.addAttribute("fromMePending", friendService.getFromMePending(user));
        model.addAttribute("toMePending", list );
        model.addAttribute("friendListing" , friendService.getFriends(user));
        model.addAttribute("sentList" , sentList);
        model.addAttribute("receivedList", receivedList);
        model.addAttribute("action", action);
        model.addAttribute("nClass",evaluationService.getNextClass());

        if(list != null) model.addAttribute("nrRequestsPending" , list.size());
        if(receivedUnreadList != null) model.addAttribute("nrMessages", receivedUnreadList.size());


        if(user != null)    model.addAttribute("User", user);
        if(action == null)  model.addAttribute("someError", "Some Error Ocurred");

        ModulePerAction mpa = moduleActionManagementService.getCurrentModule(action);

        if(mpa == null)  {
            model.addAttribute("running", "false");
            model.addAttribute("someError", "Nao se Encontra nenhum modulo a decorrer de momento");
        }
        else{
            model.addAttribute("running", "true");
            model.addAttribute("materials", fileSystemService.getMaterialList(mpa.getModule()));
        }

        if (teacherManagementService.isTeacher(mpa, user)) model.addAttribute("isTeacher", "true");
        else model.addAttribute("isTeacher", "false");

        model.addAttribute("mpa", mpa);
        model.addAttribute("evals", evaluationService.getEvaluations(mpa));

    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
