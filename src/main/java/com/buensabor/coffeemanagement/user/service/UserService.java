package com.buensabor.coffeemanagement.user.service;

import com.buensabor.coffeemanagement.user.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User findById(Long id);

    List<User> findAll();
}