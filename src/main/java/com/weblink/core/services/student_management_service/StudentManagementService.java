package com.weblink.core.services.student_management_service;

import com.weblink.core.models.Action;
import com.weblink.core.models.Student;
import com.weblink.core.models.User;

import java.util.List;


public interface StudentManagementService {
    void addStudent(Student student);
    void removeStudent(Student student);
    List<Student> getStudentList(Action action);
    List<Student> getStudentList(User user);
    List<Student> getAllStudents();
    Student getStudent(int id);
    Student getStudent(Action action, User user);
    List<Action> getAttending(User user);
}
