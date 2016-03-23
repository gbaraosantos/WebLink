package com.weblink.core.dao.course_management_dao;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.Action;
import org.springframework.stereotype.Repository;

@Repository("actionManagementDao")
public class ActionManagementDaoImpl extends AbstractDao<Integer, Action> implements ActionManagementDao {
    @Override
    public void createAction(Action action) {
        persist(action);
    }

    @Override
    public void deleteAction(Action action) {
        delete(action);
    }

    @Override
    public void updateAction(Action action) {
        update(action);
    }
}
