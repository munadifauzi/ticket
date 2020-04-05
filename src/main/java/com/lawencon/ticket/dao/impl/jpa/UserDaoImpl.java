package com.lawencon.ticket.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.ticket.dao.UserDao;
import com.lawencon.ticket.model.User;

@Repository("user_repo_jpa")
public class UserDaoImpl implements UserDao{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public List<User> findAll() throws Exception{
		return userRepo.findAll();
	}
	
	@Override
	public User save(User user) throws Exception{
		return userRepo.save(user);
	}
	
	@Override
	public void deleteById(Long id) throws Exception{
		userRepo.deleteById(id);
	}

	@Override
	public User findByid(Long id) throws Exception {
		return userRepo.findById(id).orElse(null);
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) throws Exception {
		return userRepo.findByUserNameAndPassword(userName, password);
	}

	@Override
	public User update(User user) throws Exception {
		userRepo.save(user);
		return user;
	}
	
}
