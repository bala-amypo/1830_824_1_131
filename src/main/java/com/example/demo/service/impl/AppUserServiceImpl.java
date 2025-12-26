package com.example.demo.service.impl;

import com.example.demo.entity.AppUser;
import com.example.demo.service.AppUserService;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Override
    public AppUser register(String email, String password, String role) {
        AppUser user = new AppUser();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        return user;
    }

    @Override
    public String login(String email, String password) {
        return "dummy-jwt-token";
    }
}
