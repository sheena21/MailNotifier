package com.notifier.mailNotifier.middleware;

import com.notifier.mailNotifier.entity.UserRequest;
import org.springframework.http.ResponseEntity;

public interface ProcessUpdate {
    public abstract UserRequest doOperation(long id, UserRequest userRequest) throws  Exception;
}
