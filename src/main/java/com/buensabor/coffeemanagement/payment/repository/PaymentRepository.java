package com.buensabor.coffeemanagement.payment.repository;

import com.buensabor.coffeemanagement.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}