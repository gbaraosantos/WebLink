package com.weblink.core.services.teacher_management_service;


import com.weblink.core.models.Action;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.Teacher;
import com.weblink.core.models.User;

import java.util.List;

public interface TeacherManagementService {
    void addTeacher(Teacher teacher);
    Teacher getTeacher(int id);
    void deleteTeacher(Teacher teach);
    List<Action> getTeaching(User user);
    boolean isTeacher(ModulePerAction mpa, User user);
}
