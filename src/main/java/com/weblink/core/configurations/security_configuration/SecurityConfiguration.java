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
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired CustomSuccessHandler customSuccessHandler;
    @Autowired @Qualifier("customUserDetailsService") UserDetailsService userDetailsService;
    @Autowired DataSource dataSource;

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
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
        tokenRepositoryImpl.setDataSource(dataSource);
        return tokenRepositoryImpl;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean(name = "sessionRegistry")
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/weblink/**").authenticated();

        /*Page permissions and Role attribution*/
        http.authorizeRequests()
                .antMatchers("/", "/loginMenu/").permitAll()
                .antMatchers("/admin/**").access("hasRole('Admin')")
                .antMatchers("/coord/**").access("hasRole('Coordinator')");

        http.exceptionHandling()
                .accessDeniedPage("/accessDenied");

        http.rememberMe()
                .rememberMeParameter("rememberme")
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(86400);

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
