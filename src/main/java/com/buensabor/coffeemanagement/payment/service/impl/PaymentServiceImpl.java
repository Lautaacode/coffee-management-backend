package com.buensabor.coffeemanagement.payment.service.impl;

import com.buensabor.coffeemanagement.payment.entity.Payment;
import com.buensabor.coffeemanagement.payment.entity.PaymentMethod;
import com.buensabor.coffeemanagement.payment.entity.PaymentStatus;
import com.buensabor.coffeemanagement.payment.repository.PaymentRepository;
import com.buensabor.coffeemanagement.payment.service.PaymentService;
import com.buensabor.coffeemanagement.ticket.entity.Ticket;
import com.buensabor.coffeemanagement.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final TicketRepository ticketRepository;

    public PaymentServiceImpl(
            PaymentRepository paymentRepository,
            TicketRepository ticketRepository) {

        this.paymentRepository = paymentRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Payment findById(Long id) {

        return paymentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Payment not found"));
    }

    @Override
    public List<Payment> findAll() {

        return paymentRepository.findAll();
    }

    @Override
    public Payment completePayment(
            Long paymentId,
            PaymentMethod method) {

        Payment payment = findById(paymentId);

        if(payment.getStatus() ==
                PaymentStatus.COMPLETED) {

            throw new RuntimeException(
                    "Payment already completed");
        }

        payment.setMethod(method);
        payment.setStatus(
                PaymentStatus.COMPLETED);

        return paymentRepository.save(payment);
    }

    @Override
    public Payment cancelPayment(Long paymentId) {

        Payment payment = findById(paymentId);

        if(payment.getStatus() ==
                PaymentStatus.COMPLETED) {

            throw new RuntimeException(
                    "Completed payment cannot be cancelled");
        }

        payment.setStatus(
                PaymentStatus.CANCELLED);

        return paymentRepository.save(payment);
    }

    @Override
    public Ticket findTicketByPayment(
            Long paymentId) {

        return ticketRepository
                .findByPaymentId(paymentId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Ticket not found"));
    }
}