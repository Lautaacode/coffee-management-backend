package com.buensabor.coffeemanagement.auth.service;

import com.buensabor.coffeemanagement.auth.dto.AuthResponse;
import com.buensabor.coffeemanagement.auth.dto.LoginRequest;

public interface AuthService {

    AuthResponse login(LoginRequest request);

}