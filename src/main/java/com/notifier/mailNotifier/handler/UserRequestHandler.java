package com.notifier.mailNotifier.handler;

import com.notifier.mailNotifier.entity.UserRequest;
import com.notifier.mailNotifier.middleware.ProcessWrite;
import com.notifier.mailNotifier.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRequestHandler implements ProcessWrite {

    @Autowired
    private UserRepo userRequestRepo;

    public UserRequest doOperation(UserRequest userRequest) {
        try {
            return userRequestRepo.save(userRequest);
        } catch (Exception e) {
            System.out.println("Error occured");
            return null;
        }
    }
}
