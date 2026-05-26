package com.buensabor.coffeemanagement.supply.entity;

import jakarta.persistence.*;
import com.buensabor.coffeemanagement.product.entity.Product;

@Entity
public class ProductSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Supply supply;

    private Double quantity;

    // Constructor vacío obligatorio para JPA/Hibernate
    public ProductSupply() {
    }

    // Constructor con parámetros por si necesitan crear la receta desde el código
    public ProductSupply(Product product, Supply supply, Double quantity) {
        this.product = product;
        this.supply = supply;
        this.quantity = quantity;
    }

    // Getters y Setters necesarios para que Java y la Base de Datos se comuniquen
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}