package com.weblink.core.services.loginService;


import com.weblink.core.dao.userManagementDao.UserManagementDao;
import com.weblink.core.models.User;
import com.weblink.core.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class customUserDetailsService implements UserDetailsService{

    @Autowired
    private UserManagementDao dao;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<User> users = dao.getUserByEmail(email);
        if(users==null || users.size() <= 0) throw new UsernameNotFoundException("User does not exist");

        User user = users.get(0);

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
    }


    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();

        for(UserProfile userProfile : user.getUserProfiles()){
            authorities.add(new SimpleGrantedAuthority(userProfile.getType()));
        }
        return authorities;
    }
}
