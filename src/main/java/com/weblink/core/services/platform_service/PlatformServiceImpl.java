package com.weblink.core.services.platform_service;


import com.opentok.*;
import com.opentok.exception.OpenTokException;
import com.weblink.core.dao.platform_management_dao.PlatformManagementDao;
import com.weblink.core.models.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("platformService")
@PropertySource(value = { "classpath:weblink.properties" })
@Transactional
public class PlatformServiceImpl implements PlatformService{
    @Autowired PlatformManagementDao platformManagementDao;
    @Autowired private Environment environment;




    @Override
    public String registerGlobalChat() {
        List<Platform> platforms = platformManagementDao.getPlatforms();
        OpenTok openTok = new OpenTok(Integer.parseInt(environment.getRequiredProperty("opentok.apikey")), environment.getRequiredProperty("opentok.secretkey"));
        if(platforms == null || platforms.size() == 0){
            try {
                Session session = openTok.createSession();
                platformManagementDao.addPlatform(new Platform().setGlobalChatSession(session.getSessionId()));
                return session.getSessionId();

            } catch (OpenTokException e) { e.printStackTrace(); }
        }
        else{
            return platforms.get(0).getGlobalChatSession();
        }

        return null;
    }

    @Override
    public String getTokenId() {
        OpenTok openTok = new OpenTok(Integer.parseInt(environment.getRequiredProperty("opentok.apikey")), environment.getRequiredProperty("opentok.secretkey"));
        List<Platform> platforms = platformManagementDao.getPlatforms();
        Platform p;

        if(platforms == null || platforms.size() == 0) return null;
        p = platforms.get(0);


        try {
            return openTok.generateToken(p.getGlobalChatSession());
        } catch (OpenTokException e) { return null; }


    }

    @Override
    public Platform getPlaform() {
        List<Platform> platforms = platformManagementDao.getPlatforms();
        if(platforms == null || platforms.size() == 0) return null;
        return platforms.get(0);

    }
}

































