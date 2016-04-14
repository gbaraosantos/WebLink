package com.weblink.core.dao.platform_management_dao;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.Platform;
import com.weblink.core.models.Student;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("platformManagementDao")
public class PlatformManagementDaoImpl extends AbstractDao<Integer, Platform> implements PlatformManagementDao{


    @Override
    public List<Platform> getPlatforms() {
        Query query = getSession().createQuery("FROM Platform AS p");
        return (List<Platform>)query.list();
    }

    @Override
    public void addPlatform(Platform platform) {
        persist(platform);
    }
}
