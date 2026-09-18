package com.example.expense_tracker.controller;

import jakarta.validation.Valid;
import com.example.expense_tracker.dto.LoginRequestDTO;
import com.example.expense_tracker.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequestDTO loginRequest) {

        return userService.login(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );
    }
}