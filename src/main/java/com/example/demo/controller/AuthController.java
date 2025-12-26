package com.example.demo.controller;

import com.example.demo.entity.AppUser;
import com.example.demo.service.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AppUserService appUserService;

    public AuthController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    // POST /auth/register
    @PostMapping("/register")
    public ResponseEntity<AppUser> register(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role) {
        return ResponseEntity.ok(
                appUserService.register(email, password, role));
    }

    // POST /auth/login
    @PostMapping("/login")
    public ResponseEntity<AppUser> login(
            @RequestParam String email,
            @RequestParam String password) {
        return ResponseEntity.ok(
                appUserService.login(email, password));
    }
}
