package com.buensabor.coffeemanagement.payment.dto;

import com.buensabor.coffeemanagement.payment.entity.PaymentMethod;

public class CreatePaymentRequest {

    private Double amount;

    private PaymentMethod method;

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
}