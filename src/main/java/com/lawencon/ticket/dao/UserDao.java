package com.lawencon.ticket.dao;

import java.util.List;

import com.lawencon.ticket.model.User;

public interface UserDao {

	List<User> findAll() throws Exception;

	User save(User user) throws Exception;

	void deleteById(Long id) throws Exception;

	User findByid(Long id) throws Exception;

	User findByUserNameAndPassword(String userName, String password) throws Exception;
	
	User update (User user) throws Exception;
	
}
