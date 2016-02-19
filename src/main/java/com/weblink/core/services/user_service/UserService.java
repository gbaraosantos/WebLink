package com.weblink.core.services.user_service;

import com.weblink.core.models.User;
import com.weblink.core.models.VerificationToken;

import java.util.List;


public interface UserService {
    boolean register(User user);
    List<User> getOnlineUsers();
    User getSingleUser(String email);
    String createVerificationToken(User user);
    VerificationToken getToken(String token);
    User getUser(String verificationToken);
    void activateAccount(User user);
}
