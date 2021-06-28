package com.notifier.mailNotifier.middleware;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface ProcessRead {
    public abstract List doOperation() throws Exception;
}
