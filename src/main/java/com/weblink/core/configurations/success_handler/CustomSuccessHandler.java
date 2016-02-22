package com.weblink.core.configurations.success_handler;


import com.weblink.core.common.Logger;
import com.weblink.core.models.enums.UserProfileType;
import com.weblink.core.services.user_service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@PropertySource(value = { "classpath:loginRedirect.properties" })
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
    @Autowired UserService userService;
    @Autowired private Environment environment;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {   return; }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        String url;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        JSONObject log = new JSONObject();

        log     .append("email" ,  userService.getSingleUser(getEmail()))
                .append("type", "Login");

        new Logger().log(log);

        List<String> roles = new ArrayList<>();
        for (GrantedAuthority a : authorities) {    roles.add(a.getAuthority());    }

        System.out.println(environment.getRequiredProperty("Admin.redirect"));

        if (isCoordinator(roles))           url = environment.getRequiredProperty("Coordinator.redirect");
        else if (isTeach(roles))            url = environment.getRequiredProperty("Teacher.redirect");
        else if (isAdmin(roles))            url = environment.getRequiredProperty("Admin.redirect");
        else if (isUser(roles))             url = environment.getRequiredProperty("User.redirect");
        else                                url = environment.getRequiredProperty("Other.redirect");

        return url;
    }

    private boolean isCoordinator(List<String> roles) {
        return roles.contains(UserProfileType.COORD.getUserProfileType());
    }

    private boolean isUser(List<String> roles) {
        return roles.contains(UserProfileType.USER.getUserProfileType());
    }

    private boolean isAdmin(List<String> roles) {
        return roles.contains(UserProfileType.ADMIN.getUserProfileType());
    }

    private boolean isTeach(List<String> roles) {
        return roles.contains(UserProfileType.TEACHER.getUserProfileType());
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    private String getEmail() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) userName = ((UserDetails)principal).getUsername();
        else userName = principal.toString();

        return userName;
    }

}

