package com.buensabor.coffeemanagement.orderitem.entity;

import com.buensabor.coffeemanagement.orders.entity.Orders;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import com.buensabor.coffeemanagement.shared.entity.BaseEntity;
import com.buensabor.coffeemanagement.product.entity.Product;

@Entity
public class OrderItem extends BaseEntity {

    @JsonBackReference("order-items")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    /**
     * Precio congelado al momento de la venta.
     * Si mañana cambia el precio del producto,
     * el ticket histórico no se modifica.
     */
    private Double unitPrice;

    /**
     * quantity * unitPrice
     */
    private Double subtotal;


    @PrePersist
    @PreUpdate
    public void calculateSubtotal() {

        if (unitPrice != null && quantity != null) {
            this.subtotal = unitPrice * quantity;
        }
    }

    public OrderItem() {
    }

    public OrderItem(
            Orders order,
            Product product,
            Integer quantity,
            Double unitPrice,
            Double subtotal
    ) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}