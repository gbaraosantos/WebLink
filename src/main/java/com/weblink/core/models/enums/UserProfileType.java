package com.weblink.core.models.enums;

public enum UserProfileType {
    USER("User"),
    TEACHER("Teacher"),
    COORD("Coordinator"),
    ADMIN("Admin");

    String userProfileType;

    private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType(){
        return userProfileType;
    }

}
