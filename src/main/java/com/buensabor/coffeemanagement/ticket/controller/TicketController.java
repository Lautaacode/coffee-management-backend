package com.buensabor.coffeemanagement.ticket.controller;

import com.buensabor.coffeemanagement.ticket.entity.Ticket;
import com.buensabor.coffeemanagement.ticket.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping("/generate/{tableId}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER','CASHIER')")
    public ResponseEntity<Ticket> generateTicket(
            @PathVariable Long tableId
    ) {

        return ResponseEntity.ok(
                service.generateTicket(tableId)
        );
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER','CASHIER')")
    public ResponseEntity<List<Ticket>> findAll() {

        return ResponseEntity.ok(
                service.findAll()
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER','CASHIER')")
    public ResponseEntity<Ticket> findById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.findById(id)
        );
    }
}
