package com.weblink.core.dao.course_management_dao;


import com.weblink.core.models.Course;

import java.util.List;

public interface CourseManagementDao {
    void createCourse(Course course);
    void deleteCourse(Course course);
    void updateCourse(Course course);
    List<Course> getCourse(String name);
    List<Course> getAll();
    List<Course> getCourse(int id);
}
