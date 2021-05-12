package com.notifier.mailNotifier.handler;

import com.notifier.mailNotifier.entity.UserRequest;
import com.notifier.mailNotifier.event.Mailer;
import com.notifier.mailNotifier.middleware.ProcessWrite;
import com.notifier.mailNotifier.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRequestHandler implements ProcessWrite {

    @Autowired
    private UserRepo userRequestRepo;
    @Autowired
    private Mailer mailer;

    public UserRequest doOperation(UserRequest userRequest) {
      try {
            mailer.sendSimpleMessage("mahaksaxenaa@gmail.com", " Testing email", "Look this mail for test purpose with noreply");
            return userRequestRepo.save(userRequest);
        } catch (Exception e) {
            System.out.println("Error occured while saving record");
            return null;
       }
    }
}
