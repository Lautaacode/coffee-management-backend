package com.buensabor.coffeemanagement.payment.repository;

import com.buensabor.coffeemanagement.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}