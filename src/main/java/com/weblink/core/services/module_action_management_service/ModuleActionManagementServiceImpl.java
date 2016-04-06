package com.weblink.core.services.module_action_management_service;


import com.weblink.core.dao.composite_course_management_dao.CompositeCourseManagementDao;
import com.weblink.core.dao.user_management_dao.TeacherManagementDao;
import com.weblink.core.models.Action;
import com.weblink.core.models.Module;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("moduleActionManagementService")
@Transactional
public class ModuleActionManagementServiceImpl implements ModuleActionManagementService{
    @Autowired CompositeCourseManagementDao compositeCourseManagementDao;
    @Autowired TeacherManagementDao teacherManagementDao;


    @Override
    public void addModulePerAction(Module module, Action action) {
        ModulePerAction mpa = new ModulePerAction()
                .setAction(action)
                .setModule(module);


        compositeCourseManagementDao.addModulePerAction(mpa);
        teacherManagementDao.addTeacher(new Teacher()
                .setModulePerAction(mpa)
                .setTeacher(null));

    }

    @Override
    public void addModulePerAction(ModulePerAction modulePerAction) {
        compositeCourseManagementDao.addModulePerAction(modulePerAction);

        teacherManagementDao.addTeacher(new Teacher()
                .setModulePerAction(modulePerAction)
                .setTeacher(null));
    }

    @Override
    public void updateModulePerAction(ModulePerAction modulePerAction) {
        compositeCourseManagementDao.updateModulePerAction(modulePerAction);
    }

    @Override
    public List<ModulePerAction> getMpa(Action action) {
        List<ModulePerAction> list = compositeCourseManagementDao.getMpas(action);
        if(list==null || list.size() <= 0) return null;
        return list;
    }

    @Override
    public List<Teacher> getTeacherList(Action a) {
        List<Teacher> list = teacherManagementDao.getTeacherList(a);
        if(list==null || list.size() <= 0) return null;
        return list;
    }

    @Override
    public void delete(Module module) {
        List<ModulePerAction> list = compositeCourseManagementDao.getMpas(module);

        for(ModulePerAction m : list){
            compositeCourseManagementDao.deleteModulePerAction(m);
        }
    }

    @Override
    public void delete(Action action) {
        List<ModulePerAction> list = compositeCourseManagementDao.getMpas(action);

        for(ModulePerAction m : list){
            compositeCourseManagementDao.deleteModulePerAction(m);
        }
    }
}
