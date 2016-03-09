package com.weblink.core.configurations.application_configuration;

import org.apache.velocity.app.VelocityEngine;
import org.elasticsearch.bootstrap.Elasticsearch;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.weblink.core")
@PropertySource(value = "classpath:weblink.properties")
public class AppConfiguration extends WebMvcConfigurerAdapter {
    @Autowired Environment environment;

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public SimpleMappingExceptionResolver exceptionResolver(){
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties statusCodes = new Properties();

        statusCodes.put("/WEB-INF/views/404" , "404");
        exceptionResolver.setStatusCodes(statusCodes);
        return exceptionResolver;
    }


    @Bean(name="multipartResolver")
    public CommonsMultipartResolver getResolver() throws IOException{
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(52428800); //50MB
        return resolver;
    }

    @Bean
    public VelocityEngine velocityEngine() throws IOException {
        VelocityEngineFactoryBean factory = new VelocityEngineFactoryBean();
        Properties props = new Properties();
        props.put("resource.loader", "class");
        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        factory.setVelocityProperties(props);

        return factory.createVelocityEngine();
    }

    @Bean
    public Client elasticClient(){
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


    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").resourceChain(true);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


}