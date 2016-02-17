package com.weblink.core.configurations;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.weblink.core")
public class AppConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
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

        registry.addResourceHandler("/resources/images/Arrows/**").addResourceLocations("/resources/images/Arrows/");
        registry.addResourceHandler("/resources/images/fonts/**").addResourceLocations("/resources/images/fonts/");
        registry.addResourceHandler("/resources/images/Homepage/**").addResourceLocations("/resources/images/Homepage/");
        registry.addResourceHandler("/resources/images/Login/**").addResourceLocations("/resources/images/Login/");
        registry.addResourceHandler("/resources/images/Logo/**").addResourceLocations("/resources/images/Logo/");
        registry.addResourceHandler("/resources/images/page-loader/**").addResourceLocations("/resources/images/page-loader/");
        registry.addResourceHandler("/resources/images/partners/**").addResourceLocations("/resources/images/partners/");
        registry.addResourceHandler("/resources/images/team/**").addResourceLocations("/resources/images/team/");
        registry.addResourceHandler("/resources/images/Error404/**").addResourceLocations("/resources/images/Error404/");

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