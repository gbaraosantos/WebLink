package com.weblink.core.services.userProfileService;

import com.weblink.core.dao.userProfileDao.UserProfileDao;
import com.weblink.core.models.UserProfile;
import com.weblink.core.models.enums.UserProfileType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileDao dao;

    public UserProfile getUserProfileById(int id) {
        List<UserProfile> userProfiles = dao.getUserProfileById(id);

        if(userProfiles != null && userProfiles.size() > 0)
            return userProfiles.get(0);

        return null;

    }

    public UserProfile getUserProfileByType(UserProfileType type) {
        List<UserProfile> userProfiles = dao.getUserProfileByType(type);

        if(userProfiles != null && userProfiles.size() > 0)
            return userProfiles.get(0);

        return null;
    }

    public void addUserProfile(UserProfile profile) {
        dao.addUserProfile(profile);
    }

    public void deleteUserProfile(UserProfile profile) {
        dao.deleteUserProfile(profile);
    }
}
