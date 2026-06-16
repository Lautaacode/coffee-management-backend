package com.buensabor.coffeemanagement.ticket.repository;

import com.buensabor.coffeemanagement.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findByTablesId(Long tableId);

    Optional<Ticket> findByPaymentId(Long paymentId);
}