package com.lawencon.ticket.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.ticket.model.TransactionDetail;
import com.lawencon.ticket.service.TransactionDetailService;

@RestController
public class TransactionController extends BaseController<TransactionDetail> {

	@Autowired
	TransactionDetailService transService;

	@PostMapping("transactionticket/save")
	public ResponseEntity<?> insertUnivMhs(@RequestBody String content,
			@RequestHeader("Authorization") String authorization) {
		List<TransactionDetail> listTransaction = new ArrayList<>();
		try {
			String[] auth = super.authUser(authorization);
			listTransaction = Arrays.asList(super.readValue(content, TransactionDetail.class));
			transService.save(listTransaction, auth[0], auth[1]);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>("gagal insert", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listTransaction, HttpStatus.BAD_REQUEST);
	}
}
