package com.weblink.core.services.course_management_service;


import com.weblink.core.dao.course_management_dao.ModuleManagementDao;
import com.weblink.core.dao.user_management_dao.TeacherManagementDao;
import com.weblink.core.models.Action;
import com.weblink.core.models.Course;
import com.weblink.core.models.Module;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.services.module_action_management_service.ModuleActionManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("moduleManagementService")
@Transactional
public class ModuleManagementServiceImpl implements ModuleManagementService{
    @Autowired ModuleActionManagementService moduleActionManagementService;
    @Autowired ActionManagementService actionManagementService;
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

        List <Module> moduleList = moduleManagementDao.getModulesPosHigher(module.getCourse(), module.getPosition());
        for(Module m: moduleList) moduleManagementDao.updateModule(m.setPosition(m.getPosition() - 1));



    }

    @Override
    public void updateModule(Module module) {
        moduleManagementDao.updateModule(module);
    }

    @Override
    public void addModule(Module module) {
        moduleManagementDao.addModule(module);

        for(Action a: actionManagementService.getCourseActions(module.getCourse())){
            moduleActionManagementService.addModulePerAction(module,a);
        }
    }

    @Override
    public Module getModule(Course course, int position) {
        List<Module> list = moduleManagementDao.getModule(course, position);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }
}
