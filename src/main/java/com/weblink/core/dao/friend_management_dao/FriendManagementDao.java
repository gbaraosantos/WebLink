package com.weblink.core.dao.friend_management_dao;


import com.weblink.core.models.FriendRequest;
import com.weblink.core.models.User;

import java.util.List;

public interface FriendManagementDao {
    List<FriendRequest> getToMePending(User user);
    List<FriendRequest> getFromMePending(User user);
    List<FriendRequest> getFriends(User user);
    void  addFriend(FriendRequest friendRequest);
    void  removeFriend(FriendRequest friendRequest);
    List<FriendRequest> getFriend(FriendRequest friendRequest);
    List<FriendRequest> getFriend(int id);
    void acceptFriendRequest(FriendRequest friendRequest);
}
