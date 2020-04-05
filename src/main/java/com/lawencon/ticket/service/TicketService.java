package com.lawencon.ticket.service;

import java.util.List;

import com.lawencon.ticket.model.Ticket;

public interface TicketService {

	List<Ticket> findAll(String string, String string2) throws Exception;
	
	Ticket save(Ticket ticket, String string, String string2) throws Exception;

	void deleteById(Long id, String string, String string2) throws Exception;
	
//	Ticket findByTicketTypeAndSeatAndDepartureTimeAndDepartureDate(String ticketType, String seat, String departureTime, String departureDate, String string, String string2) throws Exception;

	Ticket update(Ticket ticket, String string, String string2) throws Exception;
	
}
