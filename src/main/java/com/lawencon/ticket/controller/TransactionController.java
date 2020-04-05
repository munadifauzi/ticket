package com.lawencon.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.ticket.model.Transaction;
import com.lawencon.ticket.service.TransactionHeaderService;

@RestController
public class TransactionController extends BaseController{

	@Autowired
	TransactionHeaderService transService;
	
	@PostMapping("transactionticket/save")
	public ResponseEntity<?> insertUnivMhs(@RequestBody String content, @RequestHeader("Authorization") String authorization) { 
		Transaction transaction = new Transaction();
		try {
			String[] auth = super.authUser(authorization);
			transaction =new ObjectMapper().readValue(content, Transaction.class);
			transService.saveTransaction(transaction, auth[0], auth[1]);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>("gagal insert", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(transaction, HttpStatus.BAD_REQUEST);
	}
}
