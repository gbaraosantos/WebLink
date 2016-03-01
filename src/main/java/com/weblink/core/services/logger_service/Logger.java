package com.weblink.core.services.logger_service;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.json.JSONObject;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@PropertySource(value = "classpath:elasticsearch.properties")
public class Logger {
    @Resource  private Environment environment;
    private final String index = "weblink";

    public Logger(){}

    private String getDate(){
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
    }

    public void log(Map<String,Object> message){
        message.put("date",new Date());
        System.out.println(message);
        Client client = getClient();

        if(client == null) {    System.out.println("Elastic Search might be down"); return; }

        String type = message.get("type").toString().toLowerCase();
        message.remove("type");

        if (checkIndexExistence(index, client)) client.prepareIndex(index,type).setSource(message).get();
        else createIndex(client,index);

    }

    private Client getClient(){
        try {
            return new TransportClient.Builder().build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"),9300));
        } catch (UnknownHostException e) { e.printStackTrace(); }
        return null;
    }

    private void createIndex(Client client, String index){
        client.admin().indices().prepareCreate(index).execute().actionGet();

    }

    private boolean checkIndexExistence(String index, Client client){
        return client.admin().indices().prepareExists(index).execute().actionGet().isExists();
    }

    public void err_log(String message){
        System.err.println(getDate() + ": [" + message + "]");
    }
}
