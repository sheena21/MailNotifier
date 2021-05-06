package com.notifier.mailNotifier.middleware;

import com.notifier.mailNotifier.entity.UserRequest;

public interface ProcessReadOne {
    public abstract UserRequest doOperation(long id) throws  Exception;
}
