package com.lawencon.ticket.service;

import java.util.List;

import com.lawencon.ticket.model.User;

public interface UserService {

	List<User> findAll(String string, String string2) throws Exception;

	User save(User user) throws Exception;

	void deleteById(Long id, String string, String string2) throws Exception;

	User findByUserNameAndPassword(String userName, String password) throws Exception;
	
	User update (User user, String string, String string2) throws Exception;

}
