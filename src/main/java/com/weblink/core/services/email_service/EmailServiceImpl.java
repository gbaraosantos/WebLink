package com.weblink.core.services.email_service;

import com.weblink.core.common.Logger;
import com.weblink.core.configurations.email_configuration.EmailConfiguration;
import com.weblink.core.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service("emailService")

@PropertySource(value = { "classpath:email.properties" })
@Transactional
public class EmailServiceImpl implements EmailService{

    @Autowired private Environment environment;

    @Override
    public void sendRegistrationEmail(User user, String token) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(EmailConfiguration.class);
        ctx.refresh();
        JavaMailSenderImpl mailSender = ctx.getBean(JavaMailSenderImpl.class);

        String confirmationUrl = "https://"+environment.getProperty("email.address")+"/regitrationConfirm?token=" + token;

        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
            mailMsg.setFrom(environment.getProperty("email.from"));
            mailMsg.setTo(user.getEmail());
            mailMsg.setSubject(environment.getProperty("email.subject"));
            mailMsg.setText("Caro/a " + user.getName()
                    + ", obrigado por se registar em WebLink clique no seguinte link para activar a sua conta: "
                    + "<p href = '" +confirmationUrl + "' />");
            mailSender.send(mimeMessage);

            new Logger().log("Registration email sent to " + user.getEmail());

        }
        catch (MessagingException ex) { new Logger().err_log("Error sending verification Email");
        }



    }
}
