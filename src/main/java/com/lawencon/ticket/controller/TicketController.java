package com.lawencon.ticket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.ticket.model.Ticket;
import com.lawencon.ticket.service.TicketService;

@RestController
public class TicketController extends BaseController{

	@Autowired
	TicketService ticketService;
	
	@GetMapping("/ticket")
	public ResponseEntity<?> listTicket(@RequestHeader("Authorization") String authorization) {
		List<Ticket> listTicket = new ArrayList<>();
		try {
			String[] auth = super.authUser(authorization);
			listTicket = ticketService.findAll(auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("gagal menampilkan : ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listTicket, HttpStatus.OK);
	}
	
	@PostMapping("ticket/save")
	public ResponseEntity<?> saveTicket(@RequestBody String content, @RequestHeader("Authorization") String authorization) {
		Ticket ticket = new Ticket();
		try {
			String[] auth = super.authUser(authorization);
			ticket = new ObjectMapper().readValue(content, Ticket.class);
			ticketService.save(ticket, auth[0], auth[1]);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>("gagal insert : ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}
	
	@DeleteMapping("ticket/delete")
	public ResponseEntity<?> deleteTicket(@RequestParam Long idTicket, @RequestHeader("Authorization") String authorization) {
		try {
			String[] auth = super.authUser(authorization);
			ticketService.deleteById(idTicket, auth[0], auth[1]);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>("gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("berhasil", HttpStatus.OK);
	}
	
	@PostMapping("ticket/update")
	public ResponseEntity<?> updateTicket(@RequestBody String content, @RequestHeader("Authorization") String authorization) {
		Ticket ticket = new Ticket();
		try {
			String[] auth = super.authUser(authorization);
			ticket = new ObjectMapper().readValue(content, Ticket.class);
			ticketService.update(ticket, auth[0], auth[1]);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>("gagal insert : ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}
}
