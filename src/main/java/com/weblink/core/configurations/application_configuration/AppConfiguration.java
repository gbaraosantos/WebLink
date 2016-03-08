package com.weblink.core.configurations.application_configuration;

import org.apache.velocity.app.VelocityEngine;
import org.elasticsearch.bootstrap.Elasticsearch;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
    SimpleMappingExceptionResolver exceptionResolver(){
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
        registry.addResourceHandler("/resources/css/Bootstrap/**").addResourceLocations("/resources/css/Bootstrap/");
        registry.addResourceHandler("/resources/css/Animations/**").addResourceLocations("/resources/css/Animations/");
        registry.addResourceHandler("/resources/css/fontAwesome/Fontcss/**").addResourceLocations("/resources/css/fontAwesome/Fontcss/");
        registry.addResourceHandler("/resources/css/fontAwesome/fonts/**").addResourceLocations("/resources/css/fontAwesome/fonts/");
        registry.addResourceHandler("/resources/css/fontAwesome/less/**").addResourceLocations("/resources/css/fontAwesome/less/");
        registry.addResourceHandler("/resources/css/fontAwesome/scss/**").addResourceLocations("/resources/css/fontAwesome/scss/");
        registry.addResourceHandler("/resources/css/Login/**").addResourceLocations("/resources/css/Login/");
        registry.addResourceHandler("/resources/css/Homepage/**").addResourceLocations("/resources/css/Homepage/");
        registry.addResourceHandler("/resources/css/owlCarrosel/**").addResourceLocations("/resources/css/owlCarrosel/");
        registry.addResourceHandler("/resources/css/SweetAlerts/**").addResourceLocations("/resources/css/SweetAlerts/");
        registry.addResourceHandler("/resources/css/fonts/**").addResourceLocations("/resources/css/fonts/");
        registry.addResourceHandler("/resources/css/Error404/**").addResourceLocations("/resources/css/Error404/");
        registry.addResourceHandler("/resources/css/JQuery/**").addResourceLocations("/resources/css/JQuery/");
        registry.addResourceHandler("/resources/css/xCharts/**").addResourceLocations("/resources/css/xCharts/");
        registry.addResourceHandler("/resources/css/main/**").addResourceLocations("/resources/css/main/");

        registry.addResourceHandler("/resources/images/Arrows/**").addResourceLocations("/resources/images/Arrows/");
        registry.addResourceHandler("/resources/images/fonts/**").addResourceLocations("/resources/images/fonts/");
        registry.addResourceHandler("/resources/images/Homepage/**").addResourceLocations("/resources/images/Homepage/");
        registry.addResourceHandler("/resources/images/Login/**").addResourceLocations("/resources/images/Login/");
        registry.addResourceHandler("/resources/images/Logo/**").addResourceLocations("/resources/images/Logo/");
        registry.addResourceHandler("/resources/images/page-loader/**").addResourceLocations("/resources/images/page-loader/");
        registry.addResourceHandler("/resources/images/partners/**").addResourceLocations("/resources/images/partners/");
        registry.addResourceHandler("/resources/images/team/**").addResourceLocations("/resources/images/team/");
        registry.addResourceHandler("/resources/images/Error404/**").addResourceLocations("/resources/images/Error404/");
        registry.addResourceHandler("/resources/images/Common/**").addResourceLocations("/resources/images/Common/");

        registry.addResourceHandler("/resources/js/Error403/**").addResourceLocations("/resources/js/Error403/");
        registry.addResourceHandler("/resources/js/Animations/**").addResourceLocations("/resources/js/Animations/");
        registry.addResourceHandler("/resources/js/Bootstrap/**").addResourceLocations("/resources/js/Bootstrap/");
        registry.addResourceHandler("/resources/js/Homepage/**").addResourceLocations("/resources/js/Homepage/");
        registry.addResourceHandler("/resources/js/jQuery/**").addResourceLocations("/resources/js/jQuery/");
        registry.addResourceHandler("/resources/js/Login/**").addResourceLocations("/resources/js/Login/");
        registry.addResourceHandler("/resources/js/owlCarrosel/**").addResourceLocations("/resources/js/owlCarrosel/");
        registry.addResourceHandler("/resources/js/SweetAlerts/**").addResourceLocations("/resources/js/SweetAlerts/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


}