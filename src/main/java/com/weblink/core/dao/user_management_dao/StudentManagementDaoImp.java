package com.weblink.core.dao.user_management_dao;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.Action;
import com.weblink.core.models.Student;
import com.weblink.core.models.Teacher;
import com.weblink.core.models.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("studentManagementDao")
public class StudentManagementDaoImp extends AbstractDao<Integer, Student> implements StudentManagementDao{
    @Override
    public void addStudent(Student student) {
        persist(student);
    }

    @Override
    public void removeStudent(Student student) {
        delete(student);
    }

    @Override
    public List<Student> getStudentList(Action action) {
        Query query = getSession().createQuery("FROM Student AS s WHERE s.action = :action");
        query.setParameter("action", action);
        return (List<Student>)query.list();
    }

    @Override
    public List<Student> getStudentList(Action action, User user) {
        Query query = getSession().createQuery("FROM Student AS s WHERE s.action = :action AND s.user = :user");
        query.setParameter("action", action);
        query.setParameter("user", user);
        return (List<Student>)query.list();
    }

    @Override
    public List<Student> getStudentList(User user) {
        Query query = getSession().createQuery("FROM Student AS s WHERE s.user = :user");
        query.setParameter("user", user);
        return (List<Student>)query.list();
    }

    @Override
    public List<Student> getStudentList(int id) {
        Query query = getSession().createQuery("FROM Student AS s WHERE s.id = :id");
        query.setParameter("id", id);
        return (List<Student>)query.list();
    }

    @Override
    public List<Student> getAllStudents() {
        Query query = getSession().createQuery("FROM Student AS s");
        return (List<Student>)query.list();
    }

    @Override
    public List<Action> getStudentActions(User user) {
        Query query = getSession().createQuery("SELECT DISTINCT s.action FROM Student AS s WHERE s.user = :user AND s.action.endDate >= :now");
        query.setParameter("user", user);
        query.setParameter("now", new Date());
        return (List<Action>)query.list();
    }

    @Override
    public List<Action> getStudentActionsUpcoming(User user) {
        Query query = getSession().createQuery("SELECT DISTINCT s.action FROM Student AS s WHERE s.user = :user");
        query.setParameter("user", user);
        return (List<Action>)query.list();
    }
}
