package com.buensabor.coffeemanagement.payment.dto;

import com.buensabor.coffeemanagement.payment.entity.PaymentMethod;
import com.buensabor.coffeemanagement.payment.entity.PaymentStatus;

public class PaymentResponse {

    private Long id;

    private Double amount;

    private PaymentMethod method;

    private PaymentStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}