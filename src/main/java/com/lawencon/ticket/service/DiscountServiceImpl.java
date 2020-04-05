package com.lawencon.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.ticket.dao.DiscountDao;
import com.lawencon.ticket.model.Discount;

@Service
@Transactional
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	@Qualifier("disc_repo_hibernate") // disc_repo_jpa
	DiscountDao discDao;

	@Autowired
	UserService userService;

	@Override
	public List<Discount> findAll(String string, String string2) throws Exception {
		userService.findByUserNameAndPassword(string, string2);
		return discDao.findAll();
	}

	@Override
	public Discount save(Discount disc, String string, String string2) throws Exception {
		userService.findByUserNameAndPassword(string, string2);
		return discDao.save(disc);
	}

	@Override
	public void deleteById(Long id, String string, String string2) throws Exception {
		userService.findByUserNameAndPassword(string, string2);
		discDao.deleteById(id);
	}

	@Override
	public Discount findByDiscCode(String discCode, String string, String string2) throws Exception {
		userService.findByUserNameAndPassword(string, string2);
		return discDao.findByDiscCode(discCode);
	}

	@Override
	public Discount update(Discount disc, String string, String string2) throws Exception {
		userService.findByUserNameAndPassword(string, string2);
		return discDao.update(disc);
	}

}
