package com.weblink.core.dao.course_management_dao;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.Action;
import com.weblink.core.models.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Action> filterActions(Map<String, String> filterRequest) {
        StringBuilder query = new StringBuilder();
        StringBuilder query2 = new StringBuilder();


        query2.append("FROM Action AS a ");


        for (Map.Entry<String, String> entry : filterRequest.entrySet()) {
            if(query.length() != 0 )
                query.append(" AND ");
            else
                query.append("WHERE ");


            if(entry.getKey().equals("finalPrice") || entry.getKey().equals("startDate"))
                query.append(" a.").append(entry.getKey()).append(" <= ").append(entry.getValue());

            else if(entry.getKey().equals("id"))
                query.append(" a.createdBy.").append(entry.getKey()).append(" = ").append(entry.getValue()).append("");

            else if(entry.getKey().equals("visible"))
                query.append(" a.").append(entry.getKey()).append(" = ").append(entry.getValue()).append("");

            else
                query.append(" a.course.").append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");


        }

        if(query.length() > 0) query2.append(query);

        System.out.println(query2);
        Query query3 = getSession().createQuery(query2.toString());

        return (List<Action>)query3.list();
    }
}
