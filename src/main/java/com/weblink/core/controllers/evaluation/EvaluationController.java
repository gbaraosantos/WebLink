package com.weblink.core.controllers.evaluation;

import com.weblink.core.common.file.FileBucket;
import com.weblink.core.models.*;
import com.weblink.core.services.course_management_service.ActionManagementService;
import com.weblink.core.services.evaluation.EvaluationService;
import com.weblink.core.services.evaluation.QuestionService;
import com.weblink.core.services.evaluation.StudentPerEvaluationService;
import com.weblink.core.services.file_system_service.FileSystemService;
import com.weblink.core.services.messaging_service.MessageService;
import com.weblink.core.services.module_action_management_service.ModuleActionManagementService;
import com.weblink.core.services.student_management_service.StudentMPAService;
import com.weblink.core.services.student_management_service.StudentManagementService;
import com.weblink.core.services.teacher_management_service.TeacherManagementService;
import com.weblink.core.services.user_service.FriendService;
import com.weblink.core.services.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@Controller
public class EvaluationController {
    @Autowired UserService userService;
    @Autowired StudentManagementService studentManagementService;
    @Autowired ActionManagementService actionManagementService;
    @Autowired TeacherManagementService teacherManagementService;
    @Autowired ModuleActionManagementService moduleActionManagementService;
    @Autowired EvaluationService evaluationService;
    @Autowired QuestionService questionService;
    @Autowired StudentMPAService studentMPAService;
    @Autowired StudentPerEvaluationService studentPerEvaluationService;

    private volatile User user;

    @RequestMapping(value = "/weblink/inEval", method = RequestMethod.GET, params = {"evalId"})
    public String actionPage(Model model, @RequestParam("evalId") int evalId) {
        prepareModel(model, evalId);

        return "InEval";
    }

    @RequestMapping(value = "/weblink/evaluation", method = RequestMethod.POST, params = {"evalId"})
    public String getEvaluated(Model model, @RequestParam("evalId") int evalId, HttpServletRequest request) {
        prepareModel(model, evalId);


        Evaluation eval = evaluationService.getEvaluation(evalId);
        Set<Question> qList = eval.getQuestionList();

        int numberQ = qList.size();
        float valuePerQuestion = 100 / numberQ;
        float total = 0;

        for (Question q : qList){
            String givenAnswer = request.getParameter("q" + q.getId());

            if(givenAnswer.equals(q.getA()))
                total += valuePerQuestion;
        }

        StudentMPA smpa = studentMPAService.getStudentMPA(studentManagementService.getStudent(eval.getModulePerAction().getAction(),user),eval.getModulePerAction());


        if (studentPerEvaluationService.getStudentPerEvaluation(smpa , eval) != null)
            return "redirect:/weblink/inCourse?action=" + eval.getModulePerAction().getAction().getId();


        StudentPerEvaluation studentPerEvaluation = new StudentPerEvaluation()
                .setEvaluation(eval)
                .setStudentMPA(smpa)
                .setCompleted(true)
                .setGrade((int) Math.ceil((double) total));

        studentPerEvaluationService.addStudentPerEvaluation(studentPerEvaluation);


        return "redirect:/weblink/inCourse?action=" + eval.getModulePerAction().getAction().getId();
    }

    @RequestMapping(value = "/teacher/addQuestion", method = RequestMethod.POST, params = {"evalId"})
    public String addQuestion(Model model, @RequestParam("evalId") int evalId, HttpServletRequest request) {
        prepareModel(model, evalId);

        questionService.addQuestion(new Question()
                .setEvaluation(evaluationService.getEvaluation(evalId))
                .setQuestion(request.getParameter("question"))
                .setA(request.getParameter("correct"))
                .setB(request.getParameter("b"))
                .setC(request.getParameter("c"))
                .setD(request.getParameter("d"))
        );

        return "redirect:/weblink/inEval?evalId=" +evalId;
    }

    @RequestMapping(value = "/teacher/deleteQuestion", method = RequestMethod.GET, params = {"questionId", "evalId"})
    public String removeEval(Model model,@RequestParam("questionId") int questionId, @RequestParam("evalId") int evalId){
        prepareModel(model, evalId);

        questionService.removeQuestion(questionService.getQuestion(questionId));
        return "redirect:/weblink/inEval?evalId=" +evalId;
    }

    private void prepareModel(Model model, int evalId) {
        user = userService.getSingleUser(getEmail());
        Evaluation eval = evaluationService.getEvaluation(evalId);

        if (teacherManagementService.isTeacher(eval.getModulePerAction(), user)) model.addAttribute("isTeacher", "true");
        else model.addAttribute("isTeacher", "false");

        model.addAttribute("questions" , questionService.getQuestions(eval));
        model.addAttribute("shuffle" , questionService.getShuffledQuestions(eval));
        model.addAttribute("User", user);
        model.addAttribute("eval" , eval);

    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }
}
