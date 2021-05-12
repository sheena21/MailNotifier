package com.notifier.mailNotifier.middleware;

import com.notifier.mailNotifier.entity.UserRequest;


public interface ProcessWrite {
    public abstract UserRequest doOperation(UserRequest userRequest) throws Exception;
}