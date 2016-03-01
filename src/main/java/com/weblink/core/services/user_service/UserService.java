package com.weblink.core.services.user_service;

import com.weblink.core.models.relational.User;
import com.weblink.core.models.relational.VerificationToken;

import java.util.List;


public interface UserService {
    boolean register(User user);
    List<User> getOnlineUsers();
    User getSingleUser(String email);
    String createVerificationToken(User user);
    VerificationToken getToken(String token);
    User getUser(String verificationToken);
    VerificationToken getToken(User user);
    boolean updatePassword(User user);
    void updateUser(User user);
}
