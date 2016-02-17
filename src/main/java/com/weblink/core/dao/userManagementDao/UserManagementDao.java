package com.weblink.core.dao.userManagementDao;


import com.weblink.core.models.User;

import java.util.List;

public interface UserManagementDao {
    List<User> getUserByEmail(String email);
    void register(User user);
}
