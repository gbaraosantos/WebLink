package com.weblink.core.services.class_management_service;

import com.weblink.core.common.other.Message;
import com.weblink.core.models.User;
import com.weblink.core.services.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("classService")
public class ClassServiceImpl implements ClassService {
    @Autowired UserService userService;


    Map<Integer,List<User>> userMap = new HashMap<>();
    List<Message> messageMap = new LinkedList<>();


    @Override
    public void addUser(String metadata, int mpaId) {
        User userToAdd = userService.getSingleUser(Integer.valueOf(metadata));
        List<User> tempList = userMap.get(mpaId);

        if(tempList != null){
            for(User user : tempList){
                if(user.getId() == userToAdd.getId())
                    return;
            }
        }else{
            tempList = new LinkedList<>();
        }


        tempList.add(userToAdd);
        userMap.put(mpaId, tempList);
    }

    @Override
    public List<User> getUsers(int mpaId) {


        return userMap.get(mpaId);
    }

    @Override
    public void removeUser(String metadata, int mpaId) {
        User userToAdd = userService.getSingleUser(Integer.valueOf(metadata));
        List<User> tempList = userMap.get(mpaId);

        tempList.remove(userToAdd);
        userMap.put(mpaId, tempList);

    }

    @Override
    public void persistMessage(String string, int userId) {
        User user = userService.getSingleUser(userId);
        Message message = new Message()
                .setMessage(string)
                .setTime(new Date())
                .setUser(user);


        messageMap.add(message);
    }

    @Override
    public List<Message> getAllMessages() {
        System.out.println(messageMap);
        return messageMap;
    }


}
