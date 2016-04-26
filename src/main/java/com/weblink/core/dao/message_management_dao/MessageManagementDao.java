package com.weblink.core.dao.message_management_dao;

import com.weblink.core.models.EmailApp;
import com.weblink.core.models.User;

import java.util.List;

public interface MessageManagementDao {
    void sendMessage(EmailApp email);
    List<EmailApp> getMessage(int id);
    List<EmailApp> sentMessages(User user);
    List<EmailApp> receivedMessage (User user);
    void read(EmailApp email);
    List<EmailApp> receivedUnreadMessage(User user);
    void remove(EmailApp email);
}
