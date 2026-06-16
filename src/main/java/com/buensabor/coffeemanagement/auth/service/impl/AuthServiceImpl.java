package com.buensabor.coffeemanagement.auth.service.impl;

import com.buensabor.coffeemanagement.auth.dto.AuthResponse;
import com.buensabor.coffeemanagement.auth.dto.LoginRequest;
import com.buensabor.coffeemanagement.auth.service.AuthService;
import com.buensabor.coffeemanagement.jwt.service.JwtService;
import com.buensabor.coffeemanagement.users.entity.Users;
import com.buensabor.coffeemanagement.users.repository.UsersRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final UsersRepository usersRepository;

    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            UsersRepository usersRepository
    ) {

        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.usersRepository = usersRepository;
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));

        Users users = usersRepository.findByEmail(request.getEmail()).orElseThrow();

        String token = jwtService.generateToken(users);

        return new AuthResponse(
                token,
                users.getId(),
                users.getEmail(),
                users.getName(),
                users.getRoles()
                        .stream()
                        .map(role -> role.getName().name())
                        .toList());
    }
}