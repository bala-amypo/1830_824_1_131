package com.example.demo.service;

import com.example.demo.entity.AppUser;

public interface AppUserService {
    AppUser login(String email, String password);
}
