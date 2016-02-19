package com.weblink.core.dao.user_management_dao;

import com.weblink.core.models.User;
import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.enums.State;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userManagementDao")
public class UserManagementDaoImpl extends AbstractDao<Integer, User> implements UserManagementDao{

    @SuppressWarnings("unchecked")
    public List<User> getUserByEmail(String email) {
        Query query = getSession().createQuery("FROM User AS u WHERE u.email = :email");
        query.setParameter("email", email);
        return (List<User>)query.list();
    }

    public void register(User user) {
        persist(user);
    }

    @Override
    public void activateUser(User user) {
        System.out.println(user.getId());
        Query query = getSession().createQuery("Update User u set u.state = :state WHERE u.id = :id ");
        query.setParameter("state", State.ACTIVE.getState());
        query.setParameter("id", user.getId());
    }
}
