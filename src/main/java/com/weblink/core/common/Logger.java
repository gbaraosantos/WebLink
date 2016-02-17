package com.weblink.core.common;


public class Logger {
    String message = null;

    public Logger(){}

    public Logger(String message){
        this.message = message;
    }

    public void log(){
        System.out.println(this.message);
    }

    public void log(String message){
        System.out.println(message);
    }

    public void err_log(String message){
        System.err.println(message);
    }

    public void err_log(){
        System.err.println(this.message);
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
