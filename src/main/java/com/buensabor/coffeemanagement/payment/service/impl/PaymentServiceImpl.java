package com.buensabor.coffeemanagement.payment.service.impl;

import com.buensabor.coffeemanagement.payment.entity.Payment;
import com.buensabor.coffeemanagement.payment.entity.PaymentStatus;
import com.buensabor.coffeemanagement.payment.repository.PaymentRepository;
import com.buensabor.coffeemanagement.payment.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;

    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment create(Payment payment) {

        payment.setStatus(PaymentStatus.PENDING);

        return repository.save(payment);
    }

    @Override
    public Payment findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    public Payment completePayment(Long id) {
        Payment payment = findById(id);

        payment.setStatus(PaymentStatus.COMPLETED);

        return repository.save(payment);
    }
}