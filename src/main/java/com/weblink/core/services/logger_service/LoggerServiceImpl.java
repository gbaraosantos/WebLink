package com.weblink.core.services.logger_service;


import org.apache.lucene.queryparser.xml.FilterBuilder;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.lang.Math.toIntExact;

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

        String index = "weblink";
        if (checkIndexExistence(index)) client.prepareIndex(index,"document").setSource(message).get();
        else createIndex(index);

    }

    private void createIndex(String index){
        client.admin().indices().prepareCreate(index).execute().actionGet();

    }

    private boolean checkIndexExistence(String index){
        return client.admin().indices().prepareExists(index).execute().actionGet().isExists();
    }

    @Override
    public List<Integer> getEventsPerNDays(int nDaysPerInterval, String email) {
        List<Integer> list = new LinkedList<>();
        SearchRequestBuilder srb1 = client.prepareSearch();

        int i = 0;

        while ((i * nDaysPerInterval) <= 20){
            i++;

            srb1    .setQuery(QueryBuilders.matchQuery("email", email))
                    .setPostFilter(QueryBuilders.rangeQuery("date").from("now-" + i * nDaysPerInterval + "d").to("now-" + (i - 1) * nDaysPerInterval + "d"));

            MultiSearchResponse sr =client.prepareMultiSearch()
                    .add(srb1)
                    .execute().actionGet();

            long nbHits = 0;
            for (MultiSearchResponse.Item item : sr.getResponses()) {
                SearchResponse response = item.getResponse();
                nbHits += response.getHits().getTotalHits();
            }

            list.add( toIntExact(nbHits) );

        }

        return list;
    }

    @Override
    public int getLoginNumber(String email, int days) {
        SearchRequestBuilder srb1 = client.prepareSearch();




        srb1    .setQuery(QueryBuilders.matchQuery("email", email)).setSize(2)
                .setPostFilter(QueryBuilders.boolQuery()
                                    .must(QueryBuilders.rangeQuery("date").from("now-" + days + "d").to("now-" + 0 + "d"))
                                    .must(QueryBuilders.matchQuery("type", "Login")));

        MultiSearchResponse sr =client.prepareMultiSearch()
                .add(srb1)
                .execute().actionGet();

        long nbHits = 0;
        for (MultiSearchResponse.Item item : sr.getResponses()) {
            SearchResponse response = item.getResponse();
            nbHits += response.getHits().getTotalHits();
        }

        return toIntExact(nbHits);
    }

}
