package com.rabbit.rabbit;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;

@Component 
public class JwtUtil {

    private final String SECRET_KEY = "this-is-s-much-longer-secret-key-for-jwt-generation-please-change-it";
    public String generateToken(String username) {
        return Jwts.builder()
        .subject(username)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
        .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
        .compact();
    
}


}
