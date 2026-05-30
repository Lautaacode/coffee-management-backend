package com.buensabor.coffeemanagement.ticket.service.impl;

import com.buensabor.coffeemanagement.payment.entity.Payment;
import com.buensabor.coffeemanagement.payment.entity.PaymentStatus;
import com.buensabor.coffeemanagement.payment.repository.PaymentRepository;
import com.buensabor.coffeemanagement.tables.entity.Tables;
import com.buensabor.coffeemanagement.tables.repository.TablesRepository;
import com.buensabor.coffeemanagement.ticket.entity.Ticket;
import com.buensabor.coffeemanagement.ticket.repository.TicketRepository;
import com.buensabor.coffeemanagement.ticket.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    private final TablesRepository tableRepository;
    private final PaymentRepository paymentRepository;
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TablesRepository tableRepository,
                             PaymentRepository paymentRepository,
                             TicketRepository ticketRepository) {
        this.tableRepository = tableRepository;
        this.paymentRepository = paymentRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket generateTicket(Long tableId) {

        Tables table = tableRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("Table not found"));

        // calcular total de órdenes
        double total = table.getOrders()
                .stream()
                .flatMap(order -> order.getItems().stream())
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        // crear pago
        Payment payment = new Payment();
        payment.setAmount(total);
        payment.setStatus(PaymentStatus.PENDING);

        payment = paymentRepository.save(payment);

        // crear ticket
        Ticket ticket = new Ticket();
        ticket.setTotal(total);
        ticket.setPayment(payment);
        ticket.setTables(table);

        return ticketRepository.save(ticket);
    }
}