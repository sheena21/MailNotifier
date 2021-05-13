package com.notifier.mailNotifier.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class HomeController {
    @GetMapping("/home")
    public String getHome() {
        return "Home";
    }
}
