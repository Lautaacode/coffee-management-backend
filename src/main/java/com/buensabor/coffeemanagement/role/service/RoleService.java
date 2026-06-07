package com.buensabor.coffeemanagement.role.service;

import com.buensabor.coffeemanagement.role.entity.Role;
import com.buensabor.coffeemanagement.role.entity.RoleName;

public interface RoleService {

    Role findByName(RoleName name);

    void createRoleIfNotExist(RoleName roleName);

    boolean existsByName(RoleName roleName);

    void saveRole(Role role);
}