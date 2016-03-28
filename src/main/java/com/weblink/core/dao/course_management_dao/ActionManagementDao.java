package com.weblink.core.dao.course_management_dao;


import com.weblink.core.models.Action;

import java.util.List;

public interface ActionManagementDao {
    void createAction(Action action);
    void deleteAction(Action action);
    void updateAction(Action action);
    List<Action> getUpcoming();

    List<Action> getAction(int id);
}
