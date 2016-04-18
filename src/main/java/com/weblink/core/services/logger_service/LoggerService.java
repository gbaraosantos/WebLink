package com.weblink.core.services.logger_service;

import java.util.List;
import java.util.Map;

public interface LoggerService {
    void log(Map<String,Object> message, String level);
    List<Integer> getEventsPerNDays(int nDaysPerInterval, String email);
    int getLoginNumber(String email, int days);
}
