package com.weblink.core.dao.userProfileDao;

import com.weblink.core.models.UserProfile;
import com.weblink.core.models.enums.UserProfileType;

import java.util.List;


public interface UserProfileDao {
    List<UserProfile> getUserProfileById(Integer id);
    List<UserProfile> getUserProfileByType(UserProfileType type);
    void addUserProfile(UserProfile profile);
    void deleteUserProfile(UserProfile profile);
}
