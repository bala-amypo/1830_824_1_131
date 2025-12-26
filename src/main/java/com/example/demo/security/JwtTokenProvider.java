package com.example.demo.security;

// JWT disabled for testing & compilation
public class JwtTokenProvider {

    public String generateToken(String email) {
        return "dummy-token";
    }

    public String getEmailFromToken(String token) {
        return "dummy@email.com";
    }

    public boolean validateToken(String token) {
        return true;
    }
}
