package com.weblink.core.configurations.listeners;

import com.weblink.core.common.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{
    private int sessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        synchronized (this) {   sessionCount++; }

        new Logger().log("Session #" + sessionCount + " Created - ID: " + event.getSession().getId());
        event.getSession().setMaxInactiveInterval(30 * 60);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        synchronized (this) {   sessionCount--; }

    }
}
