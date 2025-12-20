package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AppUser;
import com.example.demo.repository.AppUserRepository;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register a new user
    public AppUser register(String email, String password, String role) {

        // check if user already exists
        if (appUserRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("User already exists with this email");
        }

        AppUser user = new AppUser();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);

        return appUserRepository.save(user);
    }

    // Login user
    public AppUser login(String email, String password) {

        AppUser user = appUserRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return user;
    }
}
