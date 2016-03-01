package com.weblink.core.services.logger_service;


import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;

@Service("loggerService")
@PropertySource(value = "classpath:weblink.properties")
public class LoggerServiceImpl implements LoggerService{
    @Autowired private Environment environment;

    public void log(Map<String,Object> message){
        message.put("date",new Date());
        System.out.println(message);
        Client client = getClient();

        if(client == null) {    System.out.println("Elastic Search might be down"); return; }

        String type = message.get("type").toString().toLowerCase();
        message.remove("type");

        String index = "weblink";
        if (checkIndexExistence(index, client)) client.prepareIndex(index,type).setSource(message).get();
        else createIndex(client, index);

    }

    private Client getClient(){
        try {
            return new TransportClient.Builder()
                    .build()
                    .addTransportAddress(
                            new InetSocketTransportAddress(
                                    InetAddress.getByName(environment.getRequiredProperty("spring.data.elasticsearch.host")),
                                    Integer.parseInt(environment.getRequiredProperty("spring.data.elasticsearch.port"))));
        } catch (UnknownHostException e) { e.printStackTrace(); }
        return null;
    }

    private void createIndex(Client client, String index){
        client.admin().indices().prepareCreate(index).execute().actionGet();

    }

    private boolean checkIndexExistence(String index, Client client){
        return client.admin().indices().prepareExists(index).execute().actionGet().isExists();
    }

}
