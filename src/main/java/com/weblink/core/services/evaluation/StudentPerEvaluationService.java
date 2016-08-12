package com.weblink.core.services.evaluation;


import com.weblink.core.models.*;

import java.util.List;

public interface StudentPerEvaluationService {
    void addStudentPerEvaluation(StudentPerEvaluation studentPerEvaluation);
    void removeStudentPerEvaluation(StudentPerEvaluation studentPerEvaluation);
    StudentPerEvaluation getStudentPerEvaluation(int id);
    List<StudentPerEvaluation> getStudentPerEvaluation(StudentMPA studentMPA);
    StudentPerEvaluation getStudentPerEvaluation(StudentMPA smpa, Evaluation evaluation);
}
