package com.buensabor.coffeemanagement.payment.entity;

<<<<<<< HEAD
import com.buensabor.coffeemanagement.order.entity.Orders;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
=======
import com.buensabor.coffeemanagement.orders.entity.Orders;
import com.buensabor.coffeemanagement.ticket.entity.Ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import com.buensabor.coffeemanagement.shared.entity.BaseEntity;
>>>>>>> sprint3

import java.time.LocalDateTime; 
import java.util.List;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @OneToOne(mappedBy = "payment")
    @JsonBackReference
    private Ticket ticket;

    
    public Payment() {
    }

<<<<<<< HEAD
    
    public Payment(
            Double amount,
            PaymentMethod method,
            PaymentStatus status,
            List<Orders> orders
    ) {
=======
    public Payment(Double amount, PaymentMethod method, PaymentStatus status, Ticket ticket) {
>>>>>>> sprint3
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.ticket = ticket;
    }

    // Automatización de auditoría temporal para los pagos
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Long getId() {
        return id;
    }

    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}