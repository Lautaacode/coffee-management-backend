package com.buensabor.coffeemanagement.users.dto;

public class CreateUsersRequest {

    private String name;

    private String lastName;

    private String dni;

    private String email;

    private String password;

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

    public String getPassword() {
        return password;
    }
}