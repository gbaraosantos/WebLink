package com.weblink.core.services.user_service;

import com.weblink.core.dao.friend_management_dao.FriendManagementDao;
import com.weblink.core.models.FriendRequest;
import com.weblink.core.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service("friendService")
public class FriendServiceImpl implements FriendService{
    @Autowired FriendManagementDao friendManagementDao;

    @Override
    public List<FriendRequest> getToMePending(User user) {
        List<FriendRequest> friendRequests = friendManagementDao.getToMePending(user);
        if(friendRequests == null || friendRequests.size() == 0)    return null;
        return friendRequests;
    }

    @Override
    public List<FriendRequest> getFromMePending(User user) {
        List<FriendRequest> friendRequests = friendManagementDao.getFromMePending(user);
        if(friendRequests == null || friendRequests.size() == 0)    return null;
        return friendRequests;
    }

    @Override
    public List<FriendRequest> getFriends(User user) {
        List<FriendRequest> friendRequests = friendManagementDao.getFriends(user);
        if(friendRequests == null || friendRequests.size() == 0)    return null;
        return friendRequests;
    }

    @Override
    public void addFriend(FriendRequest friendRequest) {
        friendManagementDao.addFriend(friendRequest);
    }

    @Override
    public void removeFriend(FriendRequest friendRequest) {
        friendManagementDao.removeFriend(friendRequest);
    }

    @Override
    public FriendRequest getFriend(FriendRequest friendRequest) {
        List<FriendRequest> friendRequests = friendManagementDao.getFriend(friendRequest);
        if(friendRequests == null || friendRequests.size() == 0)    return null;
        return friendRequests.get(0);
    }

    @Override
    public FriendRequest getFriend(int id) {
        List<FriendRequest> friendRequests = friendManagementDao.getFriend(id);
        if(friendRequests == null || friendRequests.size() == 0)    return null;
        return friendRequests.get(0);
    }

    @Override
    public void acceptFriendRequest(int id) {
        List<FriendRequest> friendRequests = friendManagementDao.getFriend(id);
        if(friendRequests != null && friendRequests.size() != 0){
            friendManagementDao.acceptFriendRequest(
                    friendRequests.get(0)
                            .setAccepteDate(new Date())
                            .setAccepted(true)
            );
        }




    }
}
