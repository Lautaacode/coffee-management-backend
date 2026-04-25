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
}