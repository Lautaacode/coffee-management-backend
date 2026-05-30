package com.buensabor.coffeemanagement.ticket.repository;

import com.buensabor.coffeemanagement.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}