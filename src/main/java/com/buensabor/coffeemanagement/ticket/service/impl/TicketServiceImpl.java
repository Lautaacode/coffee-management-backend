package com.buensabor.coffeemanagement.ticket.service.impl;

import com.buensabor.coffeemanagement.orderitem.entity.OrderItem;
import com.buensabor.coffeemanagement.payment.entity.Payment;
import com.buensabor.coffeemanagement.payment.entity.PaymentStatus;
import com.buensabor.coffeemanagement.payment.repository.PaymentRepository;
import com.buensabor.coffeemanagement.tables.entity.TableStatus;
import com.buensabor.coffeemanagement.tables.entity.Tables;
import com.buensabor.coffeemanagement.tables.repository.TablesRepository;
import com.buensabor.coffeemanagement.ticket.entity.Ticket;
import com.buensabor.coffeemanagement.ticket.repository.TicketRepository;
import com.buensabor.coffeemanagement.ticket.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .orElseThrow(() ->
                        new RuntimeException("Table not found"));

        if (table.getStatus() != TableStatus.CLOSED) {

            throw new RuntimeException(
                    "Table must be closed before generating ticket"
            );
        }

        if (ticketRepository.findByTablesId(tableId)
                .isPresent()) {

            throw new RuntimeException(
                    "Ticket already exists for this table"
            );
        }

        double total = table.getOrders()
                .stream()
                .flatMap(order ->
                        order.getItems().stream())
                .mapToDouble(OrderItem::getSubtotal)
                .sum();

        Payment payment = new Payment();

        payment.setAmount(total);
        payment.setStatus(PaymentStatus.PENDING);

        payment = paymentRepository.save(payment);

        Ticket ticket = new Ticket();

        ticket.setTotal(total);
        ticket.setPayment(payment);
        ticket.setTables(table);

        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket findById(Long id) {

        return ticketRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Ticket not found"));
    }

    @Override
    public List<Ticket> findAll() {

        return ticketRepository.findAll();
    }
}