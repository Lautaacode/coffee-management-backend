package com.buensabor.coffeemanagement.role.dto;

import com.buensabor.coffeemanagement.role.entity.RoleName;

public class RoleResponse {

    private Long id;

    private RoleName name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}