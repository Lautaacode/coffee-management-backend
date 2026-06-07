package com.buensabor.coffeemanagement.user.dto;

public class UserResponse {

    private Long id;

    private String name;

    private String lastName;

    private String dni;

    private String email;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }
}