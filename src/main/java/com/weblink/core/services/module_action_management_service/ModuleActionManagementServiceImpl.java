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

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ModulePerAction getMpa(int mpaId) {
        List<ModulePerAction> list = compositeCourseManagementDao.getMpa(mpaId);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }

    @Override
    public ModulePerAction getCurrentModule(Action action) {
        List<ModulePerAction> list = compositeCourseManagementDao.getMpas(action);
        List<ModulePerAction> newList = new LinkedList<>();

        if(list==null || list.size() <= 0) return null;

        newList.addAll(list.stream()
                .filter(mpa ->
                        !(mpa.getEndDate() == null) &&
                        !mpa.getStartDate().after(new Date()) &&
                        !mpa.getEndDate().before(new Date()))
                .collect(Collectors.toList()));



        if(newList.size() <= 0) return null;
        return newList.get(0);
    }
}
