package com.notifier.mailNotifier.handler;

import com.notifier.mailNotifier.entity.UserRequest;
import com.notifier.mailNotifier.middleware.ProcessReadOne;
import com.notifier.mailNotifier.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRemoveHandler implements ProcessReadOne {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserRequest doOperation(long id) throws Exception {
        try{
            userRepo.deleteById(id);
            return null;
        }
        catch (Exception e)
        {
            System.out.println("Exception occured while removing user");
            return  null;
        }
    }
}
