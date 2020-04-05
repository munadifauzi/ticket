package com.lawencon.ticket.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.ticket.dao.TicketDao;
import com.lawencon.ticket.model.Ticket;

@Repository("ticket_repo_jpa")
public class TicketDaoImpl implements TicketDao {

	@Autowired
	private TicketRepo ticketRepo;

	@Override
	public List<Ticket> findAll() throws Exception {
		return ticketRepo.findAll();
	}

	@Override
	public Ticket save(Ticket ticket) throws Exception {
		return ticketRepo.save(ticket);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		ticketRepo.deleteById(id);
	}

	@Override
	public Ticket findByid(Long id) throws Exception {
		return ticketRepo.findById(id).orElse(null);
	}

//	@Override
//	public Ticket findByTicketTypeAndSeatAndDepartureTimeAndDepartureDate(String ticketType, String seat,
//			String departureTime, String departureDate) throws Exception {
//		return ticketRepo.findByTicketTypeAndSeatAndDepartureTimeAndDepartureDate(ticketType, seat, departureTime, departureDate);
//	}

	@Override
	public Ticket update(Ticket ticket) throws Exception {
		ticketRepo.save(ticket);
		return ticket;
	}
	

}
