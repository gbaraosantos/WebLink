package com.weblink.core.dao.friend_management_dao;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.FriendRequest;
import com.weblink.core.models.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("friendManagementDao")
public class FriendManagementDaoImpl extends AbstractDao<Integer, FriendRequest> implements FriendManagementDao{


    @Override
    public List<FriendRequest> getToMePending(User user) {
        Query query = getSession().createQuery("FROM FriendRequest AS f WHERE f.userB = :user AND f.accepted = false");
        query.setParameter("user", user);
        return (List<FriendRequest>)query.list();
    }

    @Override
    public List<FriendRequest> getFromMePending(User user) {
        Query query = getSession().createQuery("FROM FriendRequest AS f WHERE f.userA = :user AND f.accepted = false");
        query.setParameter("user", user);
        return (List<FriendRequest>)query.list();
    }

    @Override
    public List<FriendRequest> getFriends(User user) {
        Query query = getSession().createQuery("FROM FriendRequest AS f WHERE (f.userB = :user OR f.userA = :user) AND f.accepted=true");
        query.setParameter("user", user);
        return (List<FriendRequest>)query.list();
    }

    @Override
    public void addFriend(FriendRequest friendRequest) {
        persist(friendRequest);
    }

    @Override
    public void removeFriend(FriendRequest friendRequest) {
        delete(friendRequest);
    }

    @Override
    public List<FriendRequest> getFriend(FriendRequest friendRequest) {
        Query query = getSession().createQuery("FROM FriendRequest AS f WHERE f = :friendRequest");
        query.setParameter("friendRequest", friendRequest);
        return (List<FriendRequest>)query.list();
    }

    @Override
    public List<FriendRequest> getFriend(int id) {
        Query query = getSession().createQuery("FROM FriendRequest AS f WHERE f.id = :id");
        query.setParameter("id", id);
        return (List<FriendRequest>)query.list();
    }

    @Override
    public void acceptFriendRequest(FriendRequest friendRequest) {
        update(friendRequest);
    }
}
