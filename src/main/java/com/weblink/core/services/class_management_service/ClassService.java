package com.weblink.core.services.class_management_service;

import com.weblink.core.common.other.Message;
import com.weblink.core.models.User;

import java.util.List;
import java.util.Map;

public interface ClassService {
    void addUser(String metadata, int mpaId);
    List<User> getUsers(int mpaId);
    void removeUser(String metadata, int mpaId);
    void persistMessage(String string, int userId);
    List<Message> getAllMessages();
}
