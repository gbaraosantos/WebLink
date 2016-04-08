package com.weblink.core.services.teacher_management_service;


import com.weblink.core.models.Teacher;

public interface TeacherManagementService {
    void addTeacher(Teacher teacher);
    Teacher getTeacher(int id);
    void deleteTeacher(Teacher teach);
}
