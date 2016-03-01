package com.weblink.core.configurations.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

public class SessionListener implements HttpSessionListener{
    private int sessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        synchronized (this) {   sessionCount++; }

        Map<String, Object> log = new HashMap<>();
        log.put("type", "SessionCreated");
        log.put("sessionNumber" , sessionCount);
        log.put("sessionID", event.getSession().getId());
        System.out.println(log);

        event.getSession().setMaxInactiveInterval(30 * 60);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        synchronized (this) {   sessionCount--; }

    }
}
