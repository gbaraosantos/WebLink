package com.weblink.core.dao.user_management_dao;


import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.Action;
import com.weblink.core.models.Teacher;
import com.weblink.core.models.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("teacherManagementDao")
public class TeacherManagementDaoImpl extends AbstractDao<Integer, Teacher> implements TeacherManagementDao{
    @Override
    public void addTeacher(Teacher t) {
        persist(t);
    }

    @Override
    public List<Teacher> getTeacherList(Action action) {
        Query query = getSession().createQuery("FROM Teacher AS t WHERE t.modulePerAction.action = :action");
        query.setParameter("action", action);
        return (List<Teacher>)query.list();
    }
}
