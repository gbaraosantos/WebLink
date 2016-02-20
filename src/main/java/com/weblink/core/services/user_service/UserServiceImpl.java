package com.weblink.core.services.user_service;

import com.weblink.core.dao.user_management_dao.UserManagementDao;
import com.weblink.core.dao.verification_token_dao.VerificationTokenDao;
import com.weblink.core.models.User;
import com.weblink.core.models.VerificationToken;
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
import java.util.UUID;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired private SessionRegistry sessionRegistry;
    @Autowired private UserManagementDao dao;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private VerificationTokenDao verificationTokenDao;

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
    public User getUser(String verificationToken) {
        List<VerificationToken> tokenList = verificationTokenDao.getVerificationToken(verificationToken);
        if(tokenList==null || tokenList.size() <= 0) return null;
        return tokenList.get(0).getUser();
    }

    @Override
    public void activateAccount(User user) {
        dao.activateUser(user);
    }

    @Override
    public User getSingleUser(String email){
        List<User> userList = dao.getUserByEmail(email);
        if(userList==null || userList.size() <= 0) return null;
        return userList.get(0);
    }

    @Override
    public String createVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken myToken = new VerificationToken(token, user);
        verificationTokenDao.addVerificationToken(myToken);
        return token;
    }

    @Override
    public VerificationToken getToken(String token) {
        List<VerificationToken> verificationTokens = verificationTokenDao.getVerificationToken(token);
        if(verificationTokens==null || verificationTokens.size() <= 0) throw new UsernameNotFoundException(token + ": Token Does not Exist");
        return verificationTokens.get(0);
    }
}
