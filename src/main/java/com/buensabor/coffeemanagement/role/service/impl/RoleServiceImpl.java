package com.buensabor.coffeemanagement.role.service.impl;

import com.buensabor.coffeemanagement.role.entity.Role;
import com.buensabor.coffeemanagement.role.entity.RoleName;
import com.buensabor.coffeemanagement.role.repository.RoleRepository;
import com.buensabor.coffeemanagement.role.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role findByName(RoleName name) {
        return repository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }
}