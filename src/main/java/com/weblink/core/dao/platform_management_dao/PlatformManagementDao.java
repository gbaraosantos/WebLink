package com.weblink.core.dao.platform_management_dao;


import com.weblink.core.models.Platform;

import java.util.List;

public interface PlatformManagementDao {
    List<Platform> getPlatforms();
    void addPlatform(Platform platform);
}
