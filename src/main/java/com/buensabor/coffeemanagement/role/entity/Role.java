package com.buensabor.coffeemanagement.role.entity;


import jakarta.persistence.*;
import com.buensabor.coffeemanagement.shared.BaseEntity;

@Entity
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RoleName name;

    public Role() {
    }

    public Role(RoleName name) {
        this.name = name;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}