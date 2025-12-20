package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AppUser;
import com.example.demo.repository.AppUserRepository;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    // Register
    public AppUser register(String email, String password, String role) {

        if (appUserRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        AppUser user = new AppUser();
        user.setEmail(email);
        user.setPassword(password); // plain password
        user.setRole(role);

        return appUserRepository.save(user);
    }

    // Login
    public AppUser login(String email, String password) {

        AppUser user = appUserRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password");
        }

        return user;
    }
}
