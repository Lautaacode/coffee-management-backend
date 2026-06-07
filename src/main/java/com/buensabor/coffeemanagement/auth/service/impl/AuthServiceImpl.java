package com.buensabor.coffeemanagement.auth.service.impl;

import com.buensabor.coffeemanagement.auth.dto.AuthResponse;
import com.buensabor.coffeemanagement.auth.dto.LoginRequest;
import com.buensabor.coffeemanagement.auth.service.AuthService;
import com.buensabor.coffeemanagement.jwt.JwtService;
import com.buensabor.coffeemanagement.user.entity.User;
import com.buensabor.coffeemanagement.user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            UserRepository userRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        String token = jwtService.generateToken(user);

        return new AuthResponse(token);
    }
}