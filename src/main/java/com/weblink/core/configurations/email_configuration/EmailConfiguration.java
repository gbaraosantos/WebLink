package com.weblink.core.configurations.email_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configurable
@PropertySource(value = { "classpath:email.properties" })
public class EmailConfiguration {
    @Autowired private Environment environment;

    @Bean
    public JavaMailSenderImpl javaMailSenderImpl(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(environment.getRequiredProperty("email.host"));
        mailSender.setPort(Integer.parseInt(environment.getRequiredProperty("email.port")));
        mailSender.setUsername(environment.getProperty("email.from"));
        mailSender.setPassword(environment.getProperty("email.password"));

        Properties prop = mailSender.getJavaMailProperties();

        prop.put("mail.transport.protocol", environment.getProperty("mail.transport.protocol"));
        prop.put("mail.smtp.auth", environment.getProperty("mail.smtp.auth"));
        prop.put("mail.smtp.starttls.enable", environment.getProperty("mail.smtp.starttls.enable"));
        prop.put("mail.debug", environment.getProperty("mail.debug"));
        return mailSender;
    }
}
