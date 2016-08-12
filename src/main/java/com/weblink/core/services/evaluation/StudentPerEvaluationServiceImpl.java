package com.weblink.core.services.evaluation;

import com.weblink.core.dao.evaluation.StudentPerEvaluationManagementDao;
import com.weblink.core.models.Evaluation;
import com.weblink.core.models.Question;
import com.weblink.core.models.StudentMPA;
import com.weblink.core.models.StudentPerEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("studentPerEvaluationService")
public class StudentPerEvaluationServiceImpl  implements StudentPerEvaluationService{
    @Autowired StudentPerEvaluationManagementDao studentPerEvaluationManagementDao;

    @Override
    public void addStudentPerEvaluation(StudentPerEvaluation studentPerEvaluation) {
        studentPerEvaluationManagementDao.addStudentPerEvaluation(studentPerEvaluation);
    }

    @Override
    public void removeStudentPerEvaluation(StudentPerEvaluation studentPerEvaluation) {
        studentPerEvaluationManagementDao.removeStudentPerEvaluation(studentPerEvaluation);
    }

    @Override
    public StudentPerEvaluation getStudentPerEvaluation(int id) {
        List<StudentPerEvaluation> list = studentPerEvaluationManagementDao.getStudentPerEvaluation(id);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }

    @Override
    public List<StudentPerEvaluation> getStudentPerEvaluation(StudentMPA studentMPA) {
        List<StudentPerEvaluation> list = studentPerEvaluationManagementDao.getStudentPerEvaluation(studentMPA);
        if(list==null || list.size() <= 0) return null;
        return list;
    }

    @Override
    public StudentPerEvaluation getStudentPerEvaluation(StudentMPA smpa, Evaluation evaluation) {
        List<StudentPerEvaluation> list = studentPerEvaluationManagementDao.getStudentPerEvaluation(smpa,evaluation);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }
}
