package com.notifier.mailNotifier.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("unchecked")
public class MailNotifierController {

    @GetMapping("/home")
    public String getHome()
    {
        return "Home";
    }
}
