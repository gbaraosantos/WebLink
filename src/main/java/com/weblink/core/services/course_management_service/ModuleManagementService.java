package com.weblink.core.services.course_management_service;

import com.weblink.core.models.Course;
import com.weblink.core.models.Module;

import java.util.List;

public interface ModuleManagementService {
    List<Module> getCourseModules(Course course);
    Module getModule(int id);
    void deleteModule(Module module);
    void updateModule(Module module);
    void addModule(Module module);
    Module getModule(Course course, int position);
}
