package com.weblink.core.dao.user_profile_dao;


import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.UserProfile;
import com.weblink.core.models.enums.UserProfileType;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao {

    @SuppressWarnings("unchecked")
    public List<UserProfile> getUserProfileById(Integer id) {
        Query query = getSession().createQuery("FROM UserProfile AS u WHERE u.id = :id");
        query.setString("id", id.toString());
        return (List<UserProfile>)query.list();
    }

    @SuppressWarnings("unchecked")
    public List<UserProfile> getUserProfileByType(UserProfileType type) {
        Query query = getSession().createQuery("FROM UserProfile AS u WHERE u.type = :type");
        query.setString("type", type.getUserProfileType());
        return (List<UserProfile>)query.list();
    }

    public void addUserProfile(UserProfile profile) {
        persist(profile);
    }

    public void deleteUserProfile(UserProfile profile) {
        deleteUserProfile(profile);
    }
}
