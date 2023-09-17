package com.citas.citas.security.service;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
    public String extractSubject(String token);
    public String generateToken(UserDetails userDetails, Map<String, Object> extraClaims);
    boolean isTokenValid(String token);
}
