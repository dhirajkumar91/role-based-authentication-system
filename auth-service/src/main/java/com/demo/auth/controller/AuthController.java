package com.demo.auth.controller;

import com.demo.auth.dto.LoginRequest;
import com.demo.auth.dto.LoginResponse;
import com.demo.auth.dto.RegisterRequest;
import com.demo.auth.service.JwtService;
import com.demo.auth.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication auth = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getEmail(),
                                loginRequest.getPassword()
                        )
                );

        String token = jwtService.generateToken((UserDetails) auth.getPrincipal());

        return new LoginResponse(token);
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        userService.register(
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                request.getRole()
        );

        return "User registered successfully";
    }
}