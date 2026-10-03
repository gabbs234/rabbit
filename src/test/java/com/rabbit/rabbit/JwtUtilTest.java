package com.rabbit.rabbit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import io.jsonwebtoken.JwtException;
 class JwtUtilTest {
@Test 
void tokenContainsUsername() {
    JwtUtil jwtUtil = new JwtUtil();
    String token = jwtUtil.generateToken("testuser");
    String name = jwtUtil.extractUsername(token);

    assertEquals("testuser", name);
}

    @Test
    void fakeTokenIsRejected(){
        JwtUtil jwtUtil = new JwtUtil();
       
        assertThrows(JwtException.class, () ->{
            jwtUtil.extractUsername("not-a-real-token");
        });
    }
}
