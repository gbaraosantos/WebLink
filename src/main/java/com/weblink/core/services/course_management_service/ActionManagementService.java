package com.weblink.core.services.course_management_service;


import com.weblink.core.models.Action;

public interface ActionManagementService {
    void createAction(Action action);
    void deleteAction(Action action);
    void updateAction(Action action);
}
