package com.weblink.core.dao.user_management_dao;


import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.Action;
import com.weblink.core.models.ModulePerAction;
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

    @Override
    public List<Teacher> getTeacher(int id) {
        Query query = getSession().createQuery("FROM Teacher AS t WHERE t.id = :id");
        query.setParameter("id", id);
        return (List<Teacher>)query.list();
    }

    @Override
    public void deleteTeacher(Teacher teach) {
        delete(teach);
    }

    @Override
    public List<Action> getTeaching(User user) {
        Query query = getSession().createQuery("SELECT DISTINCT s.modulePerAction.action FROM Teacher AS s WHERE s.teacher = :user");
        query.setParameter("user", user);
        return (List<Action>)query.list();
    }

    @Override
    public List<Teacher> getTeacherList(ModulePerAction mpa) {
        Query query = getSession().createQuery("FROM Teacher AS t WHERE t.modulePerAction = :mpa");
        query.setParameter("mpa", mpa);
        return (List<Teacher>)query.list();
    }
}
