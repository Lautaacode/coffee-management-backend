package com.buensabor.coffeemanagement.auth.controller;

import com.buensabor.coffeemanagement.auth.dto.AuthResponse;
import com.buensabor.coffeemanagement.auth.dto.LoginRequest;
import com.buensabor.coffeemanagement.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request
    ) {
        return ResponseEntity.ok(
                service.login(request)
        );
    }
}
