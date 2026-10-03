package com.rabbit.rabbit;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
//import lombok.Value;
import org.springframework.beans.factory.annotation.Value;
import java.util.Date;
import javax.crypto.SecretKey;

@Component 
public class JwtUtil {

    private final SecretKey key;
    public  JwtUtil(@Value("${jwt.secret}") String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }
    
    public String generateToken(String username) {
        return Jwts.builder()
        .subject(username)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
        .signWith(key)
        .compact();
    
}

    public String extractUsername(String token){
        return Jwts.parser()
        .verifyWith(key)
        .build()
        .parseSignedClaims(token)
        .getPayload()
        .getSubject();
    }


}
