package com.weblink.core.dao.user_management_dao;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.Student;
import com.weblink.core.models.StudentMPA;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentMPAManagementDao")
public class StudentMPAManagementDaoImpl extends AbstractDao<Integer, StudentMPA> implements StudentMPAManagementDao{
    @Override
    public void createStudentMPA(StudentMPA studentMPA) {
        persist(studentMPA);
    }

    @Override
    public void deleteStudentMPA(StudentMPA studentMPA) {
        delete(studentMPA);
    }

    @Override
    public void updateStudentMPA(StudentMPA studentMPA) {
        update(studentMPA);
    }

    @Override
    public List<StudentMPA> getStudentMPA(Student student, ModulePerAction mpa) {
        Query query = getSession().createQuery("FROM StudentMPA AS s WHERE s.modulePerAction = :mpa AND s.student = :student");
        query.setParameter("mpa", mpa);
        query.setParameter("student", student);
        return (List<StudentMPA>)query.list();
    }
}
