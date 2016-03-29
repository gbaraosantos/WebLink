package com.weblink.core.services.course_management_service;

import com.weblink.core.dao.course_management_dao.CourseManagementDao;
import com.weblink.core.dao.course_management_dao.ModuleManagementDao;
import com.weblink.core.models.Course;
import com.weblink.core.models.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("moduleManagementService")
@Transactional
public class ModuleManagementServiceImpl implements ModuleManagementService{

    @Autowired private ModuleManagementDao moduleManagementDao;

    @Override
    public List<Module> getCourseModules(Course course) {
        return moduleManagementDao.getCourseModules(course);
    }

    @Override
    public Module getModule(int id) {
        List<Module> list = moduleManagementDao.getModule(id);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }

    @Override
    public void deleteModule(Module module) {
        moduleManagementDao.deleteModule(module);
    }

    @Override
    public void updateModule(Module module) {
        moduleManagementDao.updateModule(module);
    }

    @Override
    public void addModule(Module module) {
        moduleManagementDao.addModule(module);
    }
}
