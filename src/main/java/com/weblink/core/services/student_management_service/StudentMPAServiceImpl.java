package com.weblink.core.services.student_management_service;

import com.weblink.core.dao.user_management_dao.StudentMPAManagementDao;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.Student;
import com.weblink.core.models.StudentMPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("studentMPAService")
public class StudentMPAServiceImpl implements StudentMPAService{
    @Autowired StudentMPAManagementDao studentMPAManagementDao;

    @Override
    public void createStudentMPA(StudentMPA studentMPA) {
        studentMPAManagementDao.createStudentMPA(studentMPA);
    }

    @Override
    public void deleteStudentMPA(StudentMPA studentMPA) {
        studentMPAManagementDao.deleteStudentMPA(studentMPA);
    }

    @Override
    public void updateStudentMPA(StudentMPA studentMPA) {
        studentMPAManagementDao.updateStudentMPA(studentMPA);
    }

    @Override
    public StudentMPA getStudentMPA(Student student, ModulePerAction mpa) {
        List<StudentMPA> list = studentMPAManagementDao.getStudentMPA(student,mpa);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }
}
