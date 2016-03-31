package com.weblink.core.dao.course_management_dao;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.Course;
import com.weblink.core.models.Module;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("moduleManagementDao")
public class ModuleManagementDaoImpl  extends AbstractDao<Integer, Module> implements ModuleManagementDao{
    @Override
    public List<Module> getCourseModules(Course course) {
        Query query = getSession().createQuery("FROM Module As m WHERE m.course = :courseId ORDER BY m.position");
        query.setParameter("courseId", course);
        return (List<Module>)query.list();
    }

    @Override
    public List<Module> getModule(int id) {
        Query query = getSession().createQuery("FROM Module As m WHERE m.id = :id");
        query.setParameter("id", id);
        return (List<Module>)query.list();
    }

    @Override
    public void deleteModule(Module module) {
        delete(module);
    }

    @Override
    public void updateModule(Module module) {
        update(module);
    }

    @Override
    public void addModule(Module module) {
        persist(module);
    }

    @Override
    public List<Module> getModule(Course course, int position) {
        Query query = getSession().createQuery("FROM Module As m WHERE m.course = :courseId AND m.position = :position ORDER BY m.position");
        query.setParameter("courseId", course);
        query.setParameter("position", position);
        return (List<Module>)query.list();
    }

    @Override
    public List<Module> getModulesPosHigher(Course course, int position) {
        Query query = getSession().createQuery("FROM Module As m WHERE m.course = :courseId AND m.position > :position ORDER BY m.position");
        query.setParameter("courseId", course);
        query.setParameter("position", position);
        return (List<Module>)query.list();
    }
}
