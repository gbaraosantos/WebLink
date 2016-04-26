package com.weblink.core.services.messaging_service;

import com.weblink.core.dao.message_management_dao.MessageManagementDao;
import com.weblink.core.models.EmailApp;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("messageService")
public class MessageServiceImpl  implements MessageService{
    @Autowired MessageManagementDao messageManagementDao;

    @Override
    public void sendMessage(EmailApp email) {
        messageManagementDao.sendMessage(email);
    }

    @Override
    public EmailApp getMessage(int id) {
        List<EmailApp> list = messageManagementDao.getMessage(id);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }

    @Override
    public List<EmailApp> sentMessages(User user) {
        List<EmailApp> list = messageManagementDao.sentMessages(user);
        if(list==null || list.size() <= 0) return null;
        return list;
    }

    @Override
    public List<EmailApp> receivedMessage(User user) {
        List<EmailApp> list = messageManagementDao.receivedMessage(user);
        if(list==null || list.size() <= 0) return null;
        return list;
    }

    @Override
    public List<EmailApp> receivedUnreadMessage(User user) {
        List<EmailApp> list = messageManagementDao.receivedUnreadMessage(user);
        if(list==null || list.size() <= 0) return null;
        return list;
    }

    @Override
    public void readMessage(EmailApp email) {
        messageManagementDao.read(email);
    }

    @Override
    public void remove(EmailApp email) {
        messageManagementDao.remove(email);
    }
}
