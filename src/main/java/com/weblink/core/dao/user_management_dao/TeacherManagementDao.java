package com.weblink.core.dao.user_management_dao;

import com.weblink.core.models.Action;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.Teacher;
import com.weblink.core.models.User;

import java.util.List;


public interface TeacherManagementDao {
    void addTeacher(Teacher t);
    List<Teacher> getTeacherList(Action action);
    List<Teacher> getTeacher(int id);
    void deleteTeacher(Teacher teach);
    List<Action> getTeaching(User user);
    List<Teacher> getTeacherList(ModulePerAction mpa);
}
