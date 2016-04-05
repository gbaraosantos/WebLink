package com.weblink.core.services.course_management_service;

import com.weblink.core.dao.course_management_dao.ActionManagementDao;
import com.weblink.core.models.Action;
import com.weblink.core.models.Course;
import com.weblink.core.models.Module;
import com.weblink.core.services.module_action_management_service.ModuleActionManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("actionManagementService")
@Transactional
public class ActionManagementServiceImpl implements ActionManagementService{
    @Autowired ModuleActionManagementService moduleActionManagementService;
    @Autowired ModuleManagementService moduleManagementService;
    @Autowired ActionManagementDao actionManagementDao;

    @Override
    public void createAction(Action action) {
        actionManagementDao.createAction(action);

        for(Module a: moduleManagementService.getCourseModules(action.getCourse())){
            moduleActionManagementService.addModulePerAction(a,action);
        }
    }

    @Override
    public void deleteAction(Action action) {
        actionManagementDao.deleteAction(action);
    }

    @Override
    public void updateAction(Action action) {
        actionManagementDao.updateAction(action);
    }

    @Override
    public List<Action> getUpcoming() {
        return actionManagementDao.getUpcoming();
    }

    @Override
    public Action getAction(int id) {
        List<Action> list = actionManagementDao.getAction(id);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }

    @Override
    public List<Action> getCourseActions(Course course) {
        List<Action> list = actionManagementDao.getCourseActions(course);
        if(list==null || list.size() <= 0) return null;
        return list;
    }

    @Override
    public List<Action> getFiltered(Map<String, String> filterRequest) {
        List<Action> list = actionManagementDao.filterActions(filterRequest);
        if(list==null || list.size() <= 0) return null;
        return list;
    }
}
