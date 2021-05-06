package com.notifier.mailNotifier.middleware;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProcessRead {
    public abstract List doOperation() throws Exception;
}
