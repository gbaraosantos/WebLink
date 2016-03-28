package com.weblink.core.services.course_management_service;


import com.weblink.core.models.Action;

import java.util.List;

public interface ActionManagementService {
    void createAction(Action action);
    void deleteAction(Action action);
    void updateAction(Action action);
    List<Action> getUpcoming();
    Action getAction(int id);
}
