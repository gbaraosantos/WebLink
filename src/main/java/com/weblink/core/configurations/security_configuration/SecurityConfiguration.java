package com.weblink.core.configurations.security_configuration;

import com.weblink.core.configurations.success_handler.CustomSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.channels.Channel;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;


    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    /*Creates the session Registry Bean to keep tabs on Users*/
    @Bean(name = "sessionRegistry")
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    /*Configuration
        CSRF: Protected
        Fixation Attack: Protected
        X-XSS Attack: Protected
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*Page permissions and Role attribution*/
        http.authorizeRequests()
                .antMatchers("/", "/loginMenu/").permitAll()
                .antMatchers("/admin/**").access("hasRole('Admin')");
        http.requiresChannel().anyRequest().requiresSecure();

        http.exceptionHandling()
                .accessDeniedPage("/accessDenied");

        /*Session Management*/
        http.sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/loginMenu?expired=true")
                .sessionRegistry(sessionRegistry());

        /*Login, Logout configuration and csrf protection*/
        http.formLogin()
                .loginPage("/loginMenu").loginProcessingUrl("/loginForm")
                .successHandler(customSuccessHandler)
                .usernameParameter("email")
                .passwordParameter("password");

        http.csrf();

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }


}
