package com.weblink.core.configurations.listeners;

import com.weblink.core.common.Logger;
import org.json.JSONObject;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{
    private int sessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        synchronized (this) {   sessionCount++; }
        JSONObject log = new JSONObject();

        log     .append("type", "SessionCreated")
                .append("sessionNumber" , sessionCount)
                .append("sessionID", event.getSession().getId());

        new Logger().log(log);
        event.getSession().setMaxInactiveInterval(30 * 60);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        synchronized (this) {   sessionCount--; }

    }
}
