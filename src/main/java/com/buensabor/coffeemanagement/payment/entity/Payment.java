package com.buensabor.coffeemanagement.payment.entity;

import jakarta.persistence.*;
import com.buensabor.coffeemanagement.shared.BaseEntity;
import com.buensabor.coffeemanagement.order.entity.Order;

import java.util.List;

@Entity
public class Payment extends BaseEntity {

    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @OneToMany
    private List<Order> orders;

    public Payment() {
    }

    public Payment(
            Double amount,
            PaymentMethod method,
            PaymentStatus status,
            List<Order> orders
    ) {
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.orders = orders;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}