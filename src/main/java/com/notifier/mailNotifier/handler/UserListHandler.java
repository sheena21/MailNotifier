package com.notifier.mailNotifier.handler;

import com.notifier.mailNotifier.middleware.ProcessRead;
import com.notifier.mailNotifier.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserListHandler implements ProcessRead {
    @Autowired
    private UserRepo userRepo;

    @Override
    public List doOperation() throws Exception {
        try {
            return userRepo.findAll();
        } catch (Exception e) {
            System.out.println("Exception occured while getting user list");
            return null;
        }
    }
}
