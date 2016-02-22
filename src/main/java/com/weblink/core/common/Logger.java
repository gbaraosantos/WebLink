package com.weblink.core.common;


import org.json.JSONObject;
import org.json.JSONString;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    public Logger(){}

    private String getDate(){
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
    }

    public void log(JSONObject message){
        System.out.println(message.append("date",getDate()));
    }

    public void err_log(String message){
        System.err.println(getDate() + ": [" + message + "]");
    }
}
