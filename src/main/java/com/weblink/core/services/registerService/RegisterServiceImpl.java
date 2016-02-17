package com.weblink.core.services.registerService;


import com.weblink.core.models.User;
import com.weblink.core.dao.userManagementDao.UserManagementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("registerService")
@Transactional
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    private UserManagementDao dao;

    public boolean checkAvailabiliy(String email) {
        return dao.getUserByEmail(email).size() <= 0;
    }

    public boolean registration(User user) {
        if (!checkAvailabiliy(user.getEmail()))   return false;
        dao.register(user);
        return true;

    }
}
