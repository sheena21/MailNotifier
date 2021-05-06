package com.notifier.mailNotifier.handler;

import com.notifier.mailNotifier.entity.UserRequest;
import com.notifier.mailNotifier.middleware.ProcessUpdate;
import com.notifier.mailNotifier.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUpdateHandler implements ProcessUpdate {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserRequest doOperation(long id, UserRequest userRequest) throws Exception {
        try {
            userRepo.findById(id);
            return userRepo.save(userRequest);
        } catch (Exception e) {
            System.out.println("Exception occured while updating user");
            return null;
        }
    }
}
