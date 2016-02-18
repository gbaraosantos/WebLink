package com.weblink.core.services.userService;

import com.weblink.core.models.User;

import java.util.List;


public interface UserService {
    boolean register(User user);
    List<User> getOnlineUsers();
    User getSingleUser(String email);
}
