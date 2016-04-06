package com.weblink.core.common.enums;

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

    public static UserProfileType getProfileType(String perm) {
        switch (perm) {
            case "Admin":           return UserProfileType.ADMIN;
            case "Coordinator":     return UserProfileType.COORD;
            case "Teacher":         return UserProfileType.TEACHER;
            default:                return UserProfileType.USER;
        }
    }
    public static int getProfileId(String type) {
        switch (type) {
            case "Admin":           return 4;
            case "Coordinator":     return 3;
            case "Teacher":         return 2;
            default:                return 1;
        }
    }

}
