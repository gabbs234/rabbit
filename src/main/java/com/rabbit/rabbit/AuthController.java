package com.rabbit.rabbit;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

@RestController
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }   

    @PostMapping("auth/register")
    public String register(@RequestBody User newUser){
        String scrambledPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(scrambledPassword);
        userRepository.save(newUser);
        return "User registered successfully!";
    }

    @PostMapping ("auth/login")
    public String login(@RequestBody User loginRequest){
        Optional <User> foundUser = userRepository.findByUsername(loginRequest.getUsername());
    

    if (foundUser.isEmpty()){
        return "User not found!";
    }

    boolean passwordMatches = passwordEncoder.matches(loginRequest.getPassword(),foundUser.get().getPassword());

    if (!passwordMatches){
        return "Invalid credentials";
    }

    return jwtUtil.generateToken(loginRequest.getUsername());
    }

}
