package com.buensabor.coffeemanagement.ticket.service;

import com.buensabor.coffeemanagement.ticket.entity.Ticket;

public interface TicketService {

    Ticket generateTicket(Long tableId);
}