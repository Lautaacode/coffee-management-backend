package com.buensabor.coffeemanagement.payment.service;

import com.buensabor.coffeemanagement.payment.entity.Payment;

public interface PaymentService {

    Payment create(Payment payment);

    Payment findById(Long id);
}