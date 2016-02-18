package com.weblink.core.services.userService;

import com.weblink.core.dao.userManagementDao.UserManagementDao;
import com.weblink.core.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired private SessionRegistry sessionRegistry;
    @Autowired private UserManagementDao dao;
    @Autowired private PasswordEncoder passwordEncoder;

    public boolean checkAvailabiliy(String email) {
        return dao.getUserByEmail(email).size() <= 0;
    }

    public boolean register(User user) {
        if (!checkAvailabiliy(user.getEmail()))   return false;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.register(user);
        return true;

    }

    @Override
    public List<User> getOnlineUsers() {
        List<User> userList = new ArrayList<>();

        List<SessionInformation> activeSessions = new ArrayList<>();
        for(Object principal : sessionRegistry.getAllPrincipals()) {
            activeSessions.addAll(sessionRegistry.getAllSessions(principal, false));
        }

        for (SessionInformation a: activeSessions) {
            UserDetails b = (UserDetails)a.getPrincipal();
            userList.add(getSingleUser(b.getUsername()));
        }

        return userList;
    }

    @Override
    public User getSingleUser(String email){
        List<User> userList = dao.getUserByEmail(email);
        if(userList==null || userList.size() <= 0) throw new UsernameNotFoundException(email + ": User does not exist");
        return userList.get(0);
    }
}
