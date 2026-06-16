package com.buensabor.coffeemanagement.auth.dto;

import java.util.List;

public class AuthResponse {

    private String token;

    private Long id;

    private String email;

    private String name;

    private List<String> roles;

    public AuthResponse(
            String token,
            Long id,
            String email,
            String name,
            List<String> roles
    ) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.name = name;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<String> getRoles() {
        return roles;
    }
}