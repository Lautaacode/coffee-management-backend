package com.buensabor.coffeemanagement.role.controller;

import com.buensabor.coffeemanagement.role.entity.Role;
import com.buensabor.coffeemanagement.role.entity.RoleName;
import com.buensabor.coffeemanagement.role.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Role> findByName(
            @PathVariable RoleName name
    ) {
        return ResponseEntity.ok(
                service.findByName(name)
        );
    }
}