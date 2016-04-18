package com.weblink.core.services.user_service;

import com.weblink.core.models.FriendRequest;
import com.weblink.core.models.User;

import java.util.List;

public interface FriendService {
    List<FriendRequest> getToMePending(User user);
    List<FriendRequest> getFromMePending(User user);
    List<FriendRequest> getFriends(User user);
    void  addFriend(FriendRequest friendRequest);
    void  removeFriend(FriendRequest friendRequest);
    FriendRequest getFriend(FriendRequest friendRequest);
    FriendRequest getFriend(int id);
    void acceptFriendRequest(int id);
}
