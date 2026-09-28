package com.rabbit.rabbit;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("auth/register")
    public String register(@RequestBody User newuser){
        String scrambledPassword = passwordEncoder.encode(newuser.getPassword());
        newuser.setPassword(scrambledPassword);
        userRepository.save(newuser);
        return "User registered successfully!";
    }

}
