package com.lawencon.ticket.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawencon.ticket.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByUserNameAndPassword(String userName, String password) throws Exception;
}
