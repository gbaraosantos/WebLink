package com.weblink.core.services.email_service;

import com.weblink.core.common.Logger;
import com.weblink.core.configurations.email_configuration.EmailConfiguration;
import com.weblink.core.models.User;
import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.velocity.VelocityEngineFactory;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;


@Service("emailService")

@PropertySource(value = { "classpath:email.properties" })
@Transactional
public class EmailServiceImpl implements EmailService{

    @Autowired private Environment environment;
    @Autowired private VelocityEngine velocityEngine;

    private JavaMailSenderImpl mailSender;


    public void emailLoader(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(EmailConfiguration.class);
        ctx.refresh();
        this.mailSender = ctx.getBean(JavaMailSenderImpl.class);

    }

    public MimeMessage prepareRegistrationEmail(String email, String username, String regLink, String subject){

        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
            mailMsg.setFrom(environment.getProperty("email.from"));
            mailMsg.setTo(email);
            mailMsg.setSubject(subject);

            Map<String, Object> model = new HashMap<>();
            model.put("user", username);
            model.put("token" , regLink);

            String content = VelocityEngineUtils.mergeTemplateIntoString(
                    velocityEngine, "./email_templates/RegistrationTemplate.vm", "UTF-8", model);
            mailMsg.setText(content, true);


            return mimeMessage;

        } catch (MessagingException ex) { new Logger().err_log("Error sending verification Email");}

        return null;
    }


    @Override
    public void sendEmail(MimeMessage mimeMessage, User user) {
        mailSender.send(mimeMessage);
        new Logger().log("New email sent to " + user.getEmail());
    }
}
