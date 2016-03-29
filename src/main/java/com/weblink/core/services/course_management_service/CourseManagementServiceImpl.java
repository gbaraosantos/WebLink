package com.weblink.core.services.course_management_service;

import com.weblink.core.dao.course_management_dao.CourseManagementDao;
import com.weblink.core.dao.verification_token_dao.VerificationTokenDao;
import com.weblink.core.models.Course;
import com.weblink.core.models.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("courseManagementService")
@Transactional
public class CourseManagementServiceImpl implements CourseManagementService{

    @Autowired private CourseManagementDao courseManagementDao;

    @Override
    public void createCourse(Course course) {
        courseManagementDao.createCourse(course);
    }

    @Override
    public void deleteCourse(Course course) {
        courseManagementDao.deleteCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseManagementDao.updateCourse(course);
    }

    @Override
    public Course getCourse(String name) {
        List<Course> list = courseManagementDao.getCourse(name);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }

    @Override
    public List<Course> getAll() {
        return courseManagementDao.getAll();
    }

    @Override
    public Course getCourse(int id) {
        List<Course> list = courseManagementDao.getCourse(id);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }
}
