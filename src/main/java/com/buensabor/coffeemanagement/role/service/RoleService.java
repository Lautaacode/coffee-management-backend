package com.buensabor.coffeemanagement.role.service;

import com.buensabor.coffeemanagement.role.entity.Role;
import com.buensabor.coffeemanagement.role.repository.RoleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado con el ID: " + id));
    }
}