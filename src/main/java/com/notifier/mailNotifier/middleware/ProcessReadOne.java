package com.notifier.mailNotifier.middleware;

import com.notifier.mailNotifier.entity.UserRequest;
import org.springframework.stereotype.Service;

@Service
public interface ProcessReadOne {
    public abstract UserRequest doOperation(long id) throws  Exception;
}
