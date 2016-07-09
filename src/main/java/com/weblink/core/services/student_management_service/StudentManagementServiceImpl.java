package com.weblink.core.services.student_management_service;

import com.weblink.core.dao.user_management_dao.StudentManagementDao;
import com.weblink.core.models.Action;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.Student;
import com.weblink.core.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("studentManagementService")
public class StudentManagementServiceImpl implements StudentManagementService{
    @Autowired StudentManagementDao studentManagementDao;

    @Override
    public void addStudent(Student student) {
        studentManagementDao.addStudent(student);
    }

    @Override
    public void removeStudent(Student student) {
        studentManagementDao.removeStudent(student);
    }

    @Override
    public List<Student> getStudentList(Action action) {
        List<Student> list = studentManagementDao.getStudentList(action);
        if(list==null || list.size() <= 0) return null;
        return list;
    }

    @Override
    public List<Student> getStudentList(User user) {
        List<Student> list = studentManagementDao.getStudentList(user);
        if(list==null || list.size() <= 0) return null;
        return list;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> list = studentManagementDao.getAllStudents();
        if(list==null || list.size() <= 0) return null;
        return list;
    }

    @Override
    public Student getStudent(int id) {
        List<Student> list = studentManagementDao.getStudentList(id);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }

    @Override
    public Student getStudent(Action action, User user) {
        List<Student> list = studentManagementDao.getStudentList(action,user);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }

    @Override
    public List<Action> getAttending(User user) {
        List<Action> list = studentManagementDao.getStudentActions(user);
        if(list==null || list.size() <= 0) return null;
        return list;
    }

    @Override
    public List<Action> getAttendingPending(User user) {
        List<Action> list = studentManagementDao.getStudentActionsUpcoming(user);
        if(list==null || list.size() <= 0) return null;
        return list;
    }

    @Override
    public List<Action> getCompleted(User user) {
        List<Action> list = studentManagementDao.getStudentCompleted(user);
        if(list==null || list.size() <= 0) return null;
        return list;
    }
}
