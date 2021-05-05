package com.notifier.mailNotifier.controller;

import com.notifier.mailNotifier.entity.UserRequest;
import com.notifier.mailNotifier.handler.UserRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@SuppressWarnings("unchecked")
public class MailNotifierController {
    @Autowired
    private UserRequestHandler userRequestHandler;

    @GetMapping("/home")
    public String getHome() {
        return "Home";
    }

    @PostMapping("/userdetail")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserRequest userRequest) {
        UserRequest user = userRequestHandler.addUser(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
