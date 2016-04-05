package com.weblink.core.dao.course_management_dao;


import com.weblink.core.models.Action;
import com.weblink.core.models.Course;

import java.util.List;
import java.util.Map;

public interface ActionManagementDao {
    void createAction(Action action);
    void deleteAction(Action action);
    void updateAction(Action action);
    List<Action> getUpcoming();
    List<Action> getAction(int id);
    List<Action> filterActions(Map<String, String> filterRequest);
    List<Action> getCourseActions(Course course);
}
