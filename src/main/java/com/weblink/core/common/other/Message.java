package com.weblink.core.common.other;

import com.weblink.core.models.User;

import java.util.Date;

public class Message {
    private String Message;
    private User user;
    private Date time;


    public String getMessage() {
        return Message;
    }

    public User getUser() {
        return user;
    }

    public Date getTime() {
        return time;
    }

    public Message setMessage(String message) {
        Message = message;
        return this;
    }

    public Message setUser(User user) {
        this.user = user;
        return this;
    }

    public Message setTime(Date time) {
        this.time = time;
        return this;
    }
}
