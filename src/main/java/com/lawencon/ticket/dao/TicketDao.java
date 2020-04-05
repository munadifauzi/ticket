package com.lawencon.ticket.dao;

import java.util.List;

import com.lawencon.ticket.model.Ticket;

public interface TicketDao {

	List<Ticket> findAll() throws Exception;

	Ticket save(Ticket ticket) throws Exception;

	void deleteById(Long id) throws Exception;

	Ticket findByid(Long id) throws Exception;

//	Ticket findByTicketTypeAndSeatAndDepartureTimeAndDepartureDate(String ticketType, String seat, String departureTime, String departureDate) throws Exception;
	
	Ticket update(Ticket ticket) throws Exception;
}
