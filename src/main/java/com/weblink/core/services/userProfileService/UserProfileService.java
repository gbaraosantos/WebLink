package com.weblink.core.services.userProfileService;


import com.weblink.core.models.UserProfile;
import com.weblink.core.models.enums.UserProfileType;

public interface UserProfileService {
    UserProfile getUserProfileById(int id);
    UserProfile getUserProfileByType(UserProfileType type);
    void addUserProfile(UserProfile profile);
    void deleteUserProfile(UserProfile profile);
}
