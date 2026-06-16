package com.buensabor.coffeemanagement.product.entity; 

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;
=======

import com.buensabor.coffeemanagement.productsupply.entity.ProductSupply;
import com.buensabor.coffeemanagement.shared.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
>>>>>>> sprint3

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    private String name;

    private String description;
    private Double price;

    private Integer stock;

    private boolean active = true;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

<<<<<<< HEAD
    private Integer stock;

    private boolean active = true; 
=======
    @JsonIgnore
    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProductSupply> supplies = new ArrayList<>();
>>>>>>> sprint3

    public Product() {
    }

    public Product(
            String name,
            String description,
            Double price,
            Integer stock,
            boolean active,
            ProductCategory category,
            List<ProductSupply> supplies
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.active = active;
        this.category = category;
        this.supplies = supplies;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

<<<<<<< HEAD
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
=======
    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public List<ProductSupply> getSupplies() {
        return supplies;
    }

    public void setSupplies(List<ProductSupply> supplies) {
        this.supplies = supplies;
>>>>>>> sprint3
    }
}