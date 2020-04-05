package com.lawencon.ticket.dao.impl.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.ticket.dao.TicketDao;
import com.lawencon.ticket.model.Ticket;

@Repository("ticket_repo_hibernate")
public class TicketDaoImpl extends BaseHibernate implements TicketDao	{

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findAll() throws Exception {
		Query q = em.createQuery("from Ticket");
		List<Ticket> listTicket = new ArrayList<>();
		listTicket = q.getResultList();
		return listTicket;
	}
	
	@Override
	public Ticket findByid(Long id) throws Exception {
		Query q = em.createQuery(" from Ticket where idVehicle = :idParam");
		q.setParameter("idParam", id);

		Ticket ticket = new Ticket();
		ticket = (Ticket) q.getSingleResult();
		return ticket;
	}
	

	@Override
	public Ticket save(Ticket ticket) throws Exception {
		em.persist(ticket);
		return ticket;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		Query q = em.createQuery(" from Ticket where idTicket = :idParam");
		q.setParameter("idParam", id);

		Ticket ticket = new Ticket();
		ticket = (Ticket) q.getSingleResult();
		em.remove(ticket);
		
	}

//	@Override
//	public Ticket findByTicketTypeAndSeatAndDepartureTimeAndDepartureDate(String ticketType, String seat,
//			String departureTime, String departureDate) throws Exception {
//	Query q = em.createQuery(" from Ticket where ticketType = :typeParam and seat = :seatParam and departureTime = :timeParam and departureDate = :dateParam");
//		q.setParameter("typeParam", ticketType);
//		q.setParameter("seatParam", seat);
//		q.setParameter("timeParam", departureTime);
//		q.setParameter("dateParam", departureDate);
//
//		Ticket ticket = new Ticket();
//		ticket = (Ticket) q.getSingleResult();
//		return ticket;
//	}

	@Override
	public Ticket update(Ticket ticket) throws Exception {
		em.merge(ticket);
		return ticket;
	}

}
