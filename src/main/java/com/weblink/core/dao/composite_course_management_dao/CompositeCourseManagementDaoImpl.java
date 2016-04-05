package com.weblink.core.dao.composite_course_management_dao;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.dao.course_management_dao.ActionManagementDao;
import com.weblink.core.models.Action;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("compositeCourseManagementDao")
public class CompositeCourseManagementDaoImpl extends AbstractDao<Integer, ModulePerAction> implements CompositeCourseManagementDao {
    @Override
    public void addModulePerAction(ModulePerAction modulePerAction) {
        persist(modulePerAction);
    }

    @Override
    public void updateModulePerAction(ModulePerAction modulePerAction) {
        update(modulePerAction);
    }

    @Override
    public List<ModulePerAction> getMpas(Action action) {
        Query query = getSession().createQuery("FROM ModulePerAction AS m WHERE m.action = :action");
        query.setParameter("action", action);
        return (List<ModulePerAction>)query.list();
    }
}
