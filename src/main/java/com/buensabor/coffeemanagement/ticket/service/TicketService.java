package com.buensabor.coffeemanagement.ticket.service;

import com.buensabor.coffeemanagement.ticket.entity.Ticket;

import java.util.List;

public interface TicketService {

    Ticket generateTicket(Long tableId);

    Ticket findById(Long id);

    List<Ticket> findAll();

}