package com.weblink.core.configurations;


import com.weblink.core.common.Logger;
import com.weblink.core.models.User;
import com.weblink.core.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
    @Autowired
    UserService userService;
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
        new Logger().log("Login: " + userService.getSingleUser(getEmail()));

        List<String> roles = new ArrayList<>();
        for (GrantedAuthority a : authorities) {    roles.add(a.getAuthority());    }

        if (isCoordinator(roles))           url = "/admin";
        else if (isTeach(roles))            url = "/admin";
        else if (isAdmin(roles))            url = "/admin";
        else if (isUser(roles))             url = "/admin";
        else                                url = "/accessDenied";


        return url;
    }

    private boolean isCoordinator(List<String> roles) {
        if (roles.contains("ROLE_Coordinator")) return true;
        return false;
    }

    private boolean isUser(List<String> roles) {
        if (roles.contains("ROLE_User")) return true;
        return false;
    }

    private boolean isAdmin(List<String> roles) {
        if (roles.contains("ROLE_Admin")) return true;
        return false;
    }

    private boolean isTeach(List<String> roles) {
        if (roles.contains("ROLE_Teacher")) return true;
        return false;
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

