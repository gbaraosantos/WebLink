package com.weblink.core.services.messaging_service;

import com.weblink.core.models.EmailApp;
import com.weblink.core.models.User;

import java.util.List;


public interface MessageService {
    void sendMessage(EmailApp email);
    EmailApp getMessage(int id);
    List<EmailApp> sentMessages(User user);
    List<EmailApp> receivedMessage (User user);
    List<EmailApp> receivedUnreadMessage(User user);
    void readMessage(EmailApp email);
}
