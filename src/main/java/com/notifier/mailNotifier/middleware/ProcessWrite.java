package com.notifier.mailNotifier.middleware;

import com.notifier.mailNotifier.entity.UserRequest;
import org.springframework.stereotype.Service;

@Service
public interface ProcessWrite {
    public abstract UserRequest doOperation(UserRequest userRequest) throws Exception;
}