package com.notifier.mailNotifier.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAnyRole('ADMIN')")
public class AdminController {

    @GetMapping()
    public String getHome() {
        return "Admin Access";
    }
}
