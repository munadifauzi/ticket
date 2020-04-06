package com.lawencon.ticket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.ticket.model.Discount;
import com.lawencon.ticket.service.DiscountService;

@RestController
public class DiscountController extends BaseController<Discount> {

	@Autowired
	DiscountService discService;
	
	@GetMapping("/discount")
	public ResponseEntity<?> listDiscount(@RequestHeader("Authorization") String authorization) {
		List<Discount> listDisc = new ArrayList<>();
		try {
			String[] auth = super.authUser(authorization);
			listDisc = discService.findAll(auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("gagal menampilkan : ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listDisc, HttpStatus.OK);
	}
	
	@PostMapping("discount/save")
	public ResponseEntity<?> saveDiscount(@RequestBody String content, @RequestHeader("Authorization") String authorization) {
		Discount disc = new Discount();
		try {
			String[] auth = super.authUser(authorization);
			disc = super.readValue(content, Discount.class);
			discService.save(disc, auth[0], auth[1]);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>("gagal insert : ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(disc, HttpStatus.OK);
	}
	
	@DeleteMapping("discount/delete")
	public ResponseEntity<?> deleteVehicle(@RequestParam Long idDiscount, @RequestHeader("Authorization") String authorization) {
		try {
			String[] auth = super.authUser(authorization);
			discService.deleteById(idDiscount, auth[0], auth[1]);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>("gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("berhasil", HttpStatus.OK);
	}
	
	@PutMapping("discount/update")
	public ResponseEntity<?> updateDiscount(@RequestBody String content, @RequestHeader("Authorization") String authorization) {
		Discount disc = new Discount();
		try {
			String[] auth = super.authUser(authorization);
			disc = super.readValue(content, Discount.class);
			discService.update(disc, auth[0], auth[1]);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>("gagal update", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(disc, HttpStatus.OK);
	}
	
}
