package com.buensabor.coffeemanagement.payment.service;

import com.buensabor.coffeemanagement.payment.entity.Payment;
import com.buensabor.coffeemanagement.payment.entity.PaymentMethod;
import com.buensabor.coffeemanagement.ticket.entity.Ticket;

import java.util.List;

public interface PaymentService {

    Payment findById(Long id);

    List<Payment> findAll();

    Payment completePayment(
            Long paymentId,
            PaymentMethod method
    );

    Payment cancelPayment(Long paymentId);

    Ticket findTicketByPayment(Long paymentId);
}