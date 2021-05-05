package com.notifier.mailNotifier.handler;

import com.notifier.mailNotifier.entity.UserRequest;
import com.notifier.mailNotifier.repo.UserRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRequestHandler {

   @Autowired
    private UserRequestRepo userRequestRepo;

    public UserRequest addUser(UserRequest userRequest) {
       return userRequestRepo.save(userRequest);
    }
}
