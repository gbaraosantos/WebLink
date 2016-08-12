package com.weblink.core.dao.evaluation;

import com.weblink.core.models.Evaluation;
import com.weblink.core.models.Student;
import com.weblink.core.models.StudentMPA;
import com.weblink.core.models.StudentPerEvaluation;

import java.util.List;

/**
 * Created by guilherme on 12-08-2016.
 */
public interface StudentPerEvaluationManagementDao {
    void addStudentPerEvaluation(StudentPerEvaluation studentPerEvaluation);
    void removeStudentPerEvaluation(StudentPerEvaluation studentPerEvaluation);
    List<StudentPerEvaluation> getStudentPerEvaluation(int id);
    List<StudentPerEvaluation> getStudentPerEvaluation(StudentMPA studentMPA);
    List<StudentPerEvaluation> getStudentPerEvaluation(StudentMPA smpa, Evaluation evaluation);
}
