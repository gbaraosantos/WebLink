package com.weblink.core.services.email_service;


import com.weblink.core.models.User;

public interface EmailService {
    void sendRegistrationEmail(User user, String token);
}
