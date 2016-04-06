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
    VerificationToken getToken(User user);
    boolean updatePassword(User user);
    void updateUser(User user);
    void deleteUser(String email);
    List getAllUsers();
    User getSingleUser(Integer id);
    List<User> getWithPermission(String teacher);
}
