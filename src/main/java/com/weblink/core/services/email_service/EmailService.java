package com.weblink.core.services.email_service;


import com.weblink.core.models.User;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

public interface EmailService {
    void sendEmail(MimeMessage mimeMessage,User user);
    void emailLoader();
    MimeMessage prepareEmail(String email,String templateName, String name, String confirmationUrl, String subject);
}
