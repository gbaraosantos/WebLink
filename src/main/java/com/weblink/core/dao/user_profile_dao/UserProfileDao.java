package com.weblink.core.dao.user_profile_dao;

import com.weblink.core.models.relational.UserProfile;
import com.weblink.core.models.enums.UserProfileType;

import java.util.List;


public interface UserProfileDao {
    List<UserProfile> getUserProfileById(Integer id);
    List<UserProfile> getUserProfileByType(UserProfileType type);
    void addUserProfile(UserProfile profile);
    void deleteUserProfile(UserProfile profile);
}
