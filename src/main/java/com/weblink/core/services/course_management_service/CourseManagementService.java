package com.weblink.core.services.course_management_service;


import com.weblink.core.models.Course;

import java.util.Map;

public interface CourseManagementService {
    void createCourse(Course course);
    void deleteCourse(Course course);
    void updateCourse(Course course);
    Course getCourse(String name);
    Object getAll();
    Course getCourse(int courseID);

}
