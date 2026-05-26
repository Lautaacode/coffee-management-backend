package com.buensabor.coffeemanagement.role.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Role { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RoleName name;

    
    public Role() {
    }

    
    public Role(RoleName name) {
        this.name = name;
    }

    // Métodos automáticos para que las fechas se registren solas al crear o editar roles
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    
    public Long getId() { 
        return id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}