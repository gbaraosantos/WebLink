package com.weblink.core.dao.course_management_dao;

import com.weblink.core.models.Course;
import com.weblink.core.models.Module;

import java.util.List;

public interface ModuleManagementDao {
    List<Module> getCourseModules(Course course);
    List<Module> getModule(int id);
    void deleteModule(Module module);
    void updateModule(Module module);
    void addModule(Module module);
    List<Module> getModule(Course course, int position);
    List<Module> getModulesPosHigher(Course course, int position);
}
