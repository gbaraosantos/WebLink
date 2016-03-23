package com.weblink.core.dao.course_management_dao;


import com.weblink.core.models.Action;

public interface ActionManagementDao {
    void createAction(Action action);
    void deleteAction(Action action);
    void updateAction(Action action);
}
