package com.rabbit.rabbit;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.util.List;
import  java.io.IOException;

@Component 
public class JwtFilter extends OncePerRequestFilter{

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil){
        
        this.jwtUtil = jwtUtil;
    }

    @Override 
    protected void  doFilterInternal(HttpServletRequest request,
                                     HttpServletResponse response,
                                     FilterChain filterChain)

                throws ServletException, IOException {
        String header = request.getHeader("Authorization");
          
        if (header !=null && header.startsWith("Bearer")) {
            try {
                String username = jwtUtil.extractUsername(header.substring(7));
                UsernamePasswordAuthenticationToken auth = 
                new UsernamePasswordAuthenticationToken(username, null, List.of());
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (Exception e) {
                //
            }
            
        }
        
        filterChain.doFilter(request, response);
    
    }


}