package com.weblink.core.dao.course_management_dao;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.Action;
import com.weblink.core.models.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("actionManagementDao")
public class ActionManagementDaoImpl extends AbstractDao<Integer, Action> implements ActionManagementDao {
    @Override
    public void createAction(Action action) {
        persist(action);
    }

    @Override
    public void deleteAction(Action action) {
        delete(action);
    }

    @Override
    public void updateAction(Action action) {
        update(action);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Action> getUpcoming() {
        Query query = getSession().createQuery("FROM Action AS a WHERE a.startDate >= :now");
        query.setParameter("now", new Date());
        return (List<Action>)query.list();
    }

    @Override
    public List<Action> getAction(int id) {
        Query query = getSession().createQuery("FROM Action AS a WHERE a.id = :id");
        query.setParameter("id", id);
        return (List<Action>)query.list();
    }
}
