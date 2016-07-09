package com.weblink.core.dao.user_management_dao;

import com.weblink.core.models.Action;
import com.weblink.core.models.Student;
import com.weblink.core.models.User;

import java.util.List;

public interface StudentManagementDao {
    void addStudent(Student student);
    void removeStudent(Student student);
    List<Student> getStudentList(Action action);
    List<Student> getStudentList(Action action, User user);
    List<Student> getStudentList(User user);
    List<Student> getStudentList(int id);
    List<Student> getAllStudents();
    List<Action>  getStudentActions(User user);

    List<Action> getStudentActionsUpcoming(User user);

    List<Action> getStudentCompleted(User user);
}
