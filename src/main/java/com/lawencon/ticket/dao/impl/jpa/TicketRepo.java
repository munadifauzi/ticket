package com.lawencon.ticket.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawencon.ticket.model.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

//	Ticket findByTicketTypeAndSeatAndDepartureTimeAndDepartureDate(String ticketType, String seat, String departureTime, String departureDate) throws Exception;
}
