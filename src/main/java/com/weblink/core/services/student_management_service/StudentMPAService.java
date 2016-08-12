package com.weblink.core.services.student_management_service;

import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.Student;
import com.weblink.core.models.StudentMPA;

/**
 * Created by guilherme on 12-08-2016.
 */
public interface StudentMPAService {
    void createStudentMPA(StudentMPA studentMPA);
    void deleteStudentMPA(StudentMPA studentMPA);
    void updateStudentMPA(StudentMPA studentMPA);
    StudentMPA getStudentMPA(Student student, ModulePerAction mpa);
}
