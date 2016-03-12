package com.weblink.core.dao.user_management_dao;


import com.weblink.core.models.User;

import java.util.List;

public interface UserManagementDao {
    List<User> getUserByEmail(String email);
    void register(User user);
    void updateUser(User user);

}
