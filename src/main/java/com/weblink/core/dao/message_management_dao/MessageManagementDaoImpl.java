package com.weblink.core.dao.message_management_dao;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.EmailApp;
import com.weblink.core.models.User;
import com.weblink.core.models.UserProfile;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("messageManagementDao")
public class MessageManagementDaoImpl extends AbstractDao<Integer, EmailApp> implements MessageManagementDao{
    @Override
    public void sendMessage(EmailApp email) {
        persist(email);
    }

    @Override
    public List<EmailApp> getMessage(int id) {
        Query query = getSession().createQuery("FROM EmailApp AS e WHERE e.id = :id");
        query.setParameter("id", id);
        return (List<EmailApp>)query.list();
    }

    @Override
    public List<EmailApp> sentMessages(User user) {
        Query query = getSession().createQuery("FROM EmailApp AS e WHERE e.userFrom = :user");
        query.setParameter("user", user);
        return (List<EmailApp>)query.list();
    }

    @Override
    public List<EmailApp> receivedMessage(User user) {
        Query query = getSession().createQuery("FROM EmailApp AS e WHERE e.userTo = :user");
        query.setParameter("user", user);
        return (List<EmailApp>)query.list();
    }

    @Override
    public void read(EmailApp email) {
        update(email);
    }

    @Override
    public List<EmailApp> receivedUnreadMessage(User user) {
        Query query = getSession().createQuery("FROM EmailApp AS e WHERE e.userTo = :user AND e.beenRead=false");
        query.setParameter("user", user);
        return (List<EmailApp>)query.list();
    }

    @Override
    public void remove(EmailApp email) {
        delete(email);
    }
}
