package com.buensabor.coffeemanagement.payment.entity;

import com.buensabor.coffeemanagement.orders.entity.Orders;
import com.buensabor.coffeemanagement.ticket.entity.Ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import com.buensabor.coffeemanagement.shared.entity.BaseEntity;

import java.util.List;

@Entity
public class Payment extends BaseEntity {

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

    public Payment(Double amount, PaymentMethod method, PaymentStatus status, Ticket ticket) {
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.ticket = ticket;
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
}