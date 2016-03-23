package com.weblink.core.services.course_management_service;

import com.weblink.core.dao.course_management_dao.ActionManagementDao;
import com.weblink.core.dao.course_management_dao.CourseManagementDao;
import com.weblink.core.models.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("actionManagementService")
@Transactional
public class ActionManagementServiceImpl implements ActionManagementService{
    @Autowired ActionManagementDao actionManagementDao;

    @Override
    public void createAction(Action action) {
        actionManagementDao.createAction(action);
    }

    @Override
    public void deleteAction(Action action) {
        actionManagementDao.deleteAction(action);
    }

    @Override
    public void updateAction(Action action) {
        actionManagementDao.updateAction(action);
    }
}
