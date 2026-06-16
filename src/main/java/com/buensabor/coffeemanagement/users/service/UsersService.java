package com.buensabor.coffeemanagement.users.service;

import com.buensabor.coffeemanagement.users.entity.Users;

import java.util.List;

public interface UsersService {

    Users create(Users users);

    Users findById(Long id);

    List<Users> findAll();

    Users update(Long id, Users users);

    void delete(Long id);

    void createAdminIfNotExists();
}