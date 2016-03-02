package com.weblink.core.services.logger_service;


import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service("loggerService")
@PropertySource(value = "classpath:weblink.properties")
public class LoggerServiceImpl implements LoggerService{
    @Autowired private Client client;

    public void log(Map<String,Object> message, String level){
        message.put("date",new Date());
        message.put("level",level);

        System.out.println(message);

        if(client == null) {    System.out.println("Elastic Search might be down"); return; }

        String type = message.get("type").toString().toLowerCase();
        message.remove("type");

        String index = "weblink";
        if (checkIndexExistence(index)) client.prepareIndex(index,type).setSource(message).get();
        else createIndex(index);

    }

    private void createIndex(String index){
        client.admin().indices().prepareCreate(index).execute().actionGet();

    }

    private boolean checkIndexExistence(String index){
        return client.admin().indices().prepareExists(index).execute().actionGet().isExists();
    }

}
