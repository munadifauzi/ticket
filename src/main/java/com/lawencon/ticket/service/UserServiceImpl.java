package com.lawencon.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.ticket.dao.UserDao;
import com.lawencon.ticket.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("user_repo_hibernate") //user_repo_jpa
	UserDao userDao;

	@Override
	public User save(User user) throws Exception {
		return userDao.save(user);
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) throws Exception {
		return userDao.findByUserNameAndPassword(userName, password);
	}
	@Override
	public List<User> findAll(String string, String string2) throws Exception {
		findByUserNameAndPassword(string, string2);
		return userDao.findAll();
	}


	@Override
	public void deleteById(Long id, String string, String string2) throws Exception {
		userDao.deleteById(id);
		
	}

	@Override
	public User update(User user, String string, String string2) throws Exception {
		findByUserNameAndPassword(string, string2);
		return userDao.update(user);
	}
	

}
