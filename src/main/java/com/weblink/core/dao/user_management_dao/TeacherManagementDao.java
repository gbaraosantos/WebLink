package com.weblink.core.dao.user_management_dao;

import com.weblink.core.models.Action;
import com.weblink.core.models.Teacher;

import java.util.List;


public interface TeacherManagementDao {
    void addTeacher(Teacher t);
    List<Teacher> getTeacherList(Action action);
    List<Teacher> getTeacher(int id);
    void deleteTeacher(Teacher teach);
}
