package com.weblink.core.dao.course_management_dao;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.dao.user_management_dao.UserManagementDao;
import com.weblink.core.models.Course;
import com.weblink.core.models.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courseManagementDao")
public class CourseManagementDaoImpl extends AbstractDao<Integer, Course>  implements CourseManagementDao{

    @Override
    public void createCourse(Course course) {
        persist(course);
    }

    @Override
    public void deleteCourse(Course course) {
        delete(course);
    }

    @Override
    public void updateCourse(Course course) {
        update(course);
    }

    @Override
    public List<Course> getCourse(String name) {
        Query query = getSession().createQuery("FROM Course AS u WHERE u.name = :name");
        query.setParameter("name", name);
        return (List<Course>)query.list();
    }
}
