package com.weblink.core.common;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    String message = null;

    public Logger(){}

    public Logger(String message){
        this.message = getDate() + ": [" + message + "]";
    }

    private String getDate(){
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
    }

    public void log(){
        System.out.println(this.message);
    }

    public void log(String message){System.out.println(getDate() + ": [" + message + "]");}

    public void err_log(String message){
        System.err.println(getDate() + ": [" + message + "]");
    }

    public void err_log(){
        System.err.println(this.message);
    }

    public void setMessage(String message){
        this.message = getDate() + ": [" + message + "]";
    }

    public String getMessage(){
        return this.message;
    }
}
