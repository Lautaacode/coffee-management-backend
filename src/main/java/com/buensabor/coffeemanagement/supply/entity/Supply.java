package com.buensabor.coffeemanagement.supply.entity;

import com.buensabor.coffeemanagement.productsupply.entity.ProductSupply;
import com.buensabor.coffeemanagement.shared.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
<<<<<<< HEAD
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist; 
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime; 
=======
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

>>>>>>> sprint3

@Entity
public class Supply { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String name;

    private Integer stock;

    private Double cost;

<<<<<<< HEAD
    
    public Supply() {
    }

    
    public Supply(String name, Integer stock, Double cost) {
=======

    @JsonIgnore
    @OneToMany(mappedBy = "supply")
    private List<ProductSupply> products = new ArrayList<>();

    public Supply() {
    }

    public Supply(
            String name,
            Integer stock,
            Double cost,
            List<ProductSupply> products
    ) {
>>>>>>> sprint3
        this.name = name;
        this.stock = stock;
        this.cost = cost;
        this.products = products;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

<<<<<<< HEAD
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
=======
    public List<ProductSupply> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSupply> products) {
        this.products = products;
    }
}
>>>>>>> sprint3
