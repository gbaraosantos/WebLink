package com.weblink.core.services.platform_service;


import com.weblink.core.models.Platform;

public interface PlatformService {
    String registerGlobalChat();
    String getTokenId();
    Platform getPlaform();
}
