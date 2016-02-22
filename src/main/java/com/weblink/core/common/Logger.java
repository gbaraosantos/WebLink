package com.weblink.core.common;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    public Logger(){}

    private String getDate(){
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
    }

    public void log(String message){System.out.println(getDate() + ": [" + message + "]");}

    public void err_log(String message){
        System.err.println(getDate() + ": [" + message + "]");
    }
}
