package com.buensabor.coffeemanagement.payment.controller;

import com.buensabor.coffeemanagement.payment.entity.Payment;
import com.buensabor.coffeemanagement.payment.entity.PaymentMethod;
import com.buensabor.coffeemanagement.payment.service.PaymentService;
import com.buensabor.coffeemanagement.ticket.entity.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(
            PaymentService service) {

        this.service = service;
    }

    @GetMapping
    @PreAuthorize(
            "hasAnyRole('SUPER_ADMIN','MANAGER','CASHIER')")
    public ResponseEntity<List<Payment>> findAll() {

        return ResponseEntity.ok(
                service.findAll()
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize(
            "hasAnyRole('SUPER_ADMIN','MANAGER','CASHIER')")
    public ResponseEntity<Payment> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.findById(id)
        );
    }

    @PatchMapping("/{id}/complete")
    @PreAuthorize(
            "hasAnyRole('SUPER_ADMIN','MANAGER','CASHIER')")
    public ResponseEntity<Payment> completePayment(

            @PathVariable Long id,

            @RequestParam
            PaymentMethod method
    ) {

        return ResponseEntity.ok(
                service.completePayment(
                        id,
                        method
                )
        );
    }

    @PatchMapping("/{id}/cancel")
    @PreAuthorize(
            "hasAnyRole('SUPER_ADMIN','MANAGER','CASHIER')")
    public ResponseEntity<Payment> cancelPayment(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.cancelPayment(id)
        );
    }

    @GetMapping("/{id}/ticket")
    @PreAuthorize(
            "hasAnyRole('SUPER_ADMIN','MANAGER','CASHIER')")
    public ResponseEntity<Ticket> findTicketByPayment(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.findTicketByPayment(id)
        );
    }
}