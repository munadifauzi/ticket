package com.lawencon.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.ticket.dao.TicketDao;
import com.lawencon.ticket.model.Ticket;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

	@Autowired
	@Qualifier("ticket_repo_hibernate") //ticket_repo_jpa
	TicketDao ticketDao;
	
	@Autowired
	UserService userService;
	
	@Override
	public List<Ticket> findAll(String string, String string2) throws Exception {
		userService.findByUserNameAndPassword(string, string2);
		return ticketDao.findAll();
	}
	
	@Override
	public Ticket save(Ticket ticket, String string, String string2) throws Exception {
		userService.findByUserNameAndPassword(string, string2);
		return ticketDao.save(ticket);		
	}

	@Override
	public void deleteById(Long id, String string, String string2) throws Exception {
		userService.findByUserNameAndPassword(string, string2);
		ticketDao.deleteById(id);
	}

//	@Override
//	public Ticket findByTicketTypeAndSeatAndDepartureTimeAndDepartureDate(String ticketType, String seat,
//			String departureTime, String departureDate, String string, String string2) throws Exception {
//		userService.findByUserNameAndPassword(string, string2);
//		return ticketDao.findByTicketTypeAndSeatAndDepartureTimeAndDepartureDate(ticketType, seat, departureTime, departureDate);
//	}

	@Override
	public Ticket update(Ticket ticket, String string, String string2) throws Exception {
		userService.findByUserNameAndPassword(string, string2);
		return ticketDao.update(ticket);
	}

}
