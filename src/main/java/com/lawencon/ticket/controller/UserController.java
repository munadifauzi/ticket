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

import com.lawencon.ticket.model.User;
import com.lawencon.ticket.service.UserService;

@RestController
public class UserController extends BaseController<User> {

	@Autowired
	UserService userService;
	
	@GetMapping("user")
	public ResponseEntity<?> listUser(@RequestHeader("Authorization") String authorization) {
		List<User> listUser = new ArrayList<>();
		try {
			String[] auth = super.authUser(authorization);
			listUser = userService.findAll(auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("gagal menampilkan : ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listUser, HttpStatus.OK);
	}
	
	@PostMapping("user/save")
	public ResponseEntity<?> saveUser(@RequestBody String content) {
		User user = new User();
		try {
			user = super.readValue(content, User.class);
			userService.save(user);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>("gagal insert : ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("user/delete")
	public ResponseEntity<?> deleteUser(@RequestParam Long idUser, @RequestHeader("Authorization") String authorization) {
		try {
			String[] auth = super.authUser(authorization);
			userService.deleteById(idUser, auth[0], auth[1]);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>("gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("berhasil", HttpStatus.OK);
	}
	
	@PutMapping("user/update")
	public ResponseEntity<?> updateUser(@RequestBody String content, @RequestHeader("Authorization") String authorization) {
		User user = new User();
		try {
			String[] auth = super.authUser(authorization);
			user = super.readValue(content, User.class);
			userService.update(user, auth[0], auth[1]);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>("gagal update", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
