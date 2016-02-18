package com.weblink.core.dao.user_management_dao;

import com.weblink.core.models.User;
import com.weblink.core.dao.AbstractDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userManagementDao")
public class UserManagementDaoImpl extends AbstractDao<Integer, User> implements UserManagementDao{

    @SuppressWarnings("unchecked")
    public List<User> getUserByEmail(String email) {
        Query query = getSession().createQuery("FROM User AS u WHERE u.email = :email");
        query.setString("email", email);
        return (List<User>)query.list();
    }

    public void register(User user) {
        persist(user);
    }
}
