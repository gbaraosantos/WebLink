package com.weblink.core.dao.user_management_dao;


import com.weblink.core.models.*;

import java.util.List;
import java.util.Map;

public interface StudentMPAManagementDao {
    void createStudentMPA(StudentMPA studentMPA);
    void deleteStudentMPA(StudentMPA studentMPA);
    void updateStudentMPA(StudentMPA studentMPA);
    List<StudentMPA> getStudentMPA(Student student, ModulePerAction mpa);

}
