package com.weblink.core.common.enums;

public enum CourseType {
    SYNCHRONOUS("Synch"),
    ASYNCHRONOUS("Asynch"),
    BLENDED("Blended");

    private String courseType;

    CourseType(final String extension){
        this.courseType = extension;
    }

    public String getCourseType(){
        return this.courseType;
    }

    @Override
    public String toString(){
        return this.courseType;
    }

    public String getName(){
        return this.name();
    }
}
