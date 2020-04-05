package com.lawencon.ticket.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.ticket.dao.DiscountDao;
import com.lawencon.ticket.model.Discount;

@Repository("disc_repo_jpa")
public class DiscountDaoImpl implements DiscountDao {

	@Autowired
	private DiscountRepo discRepo;
	
	@Override
	public List<Discount> findAll() throws Exception{
		return discRepo.findAll();
	}
	
	@Override
	public Discount save(Discount disc) throws Exception {
		return discRepo.save(disc);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		discRepo.deleteById(id);
	}

	@Override
	public Discount findByid(Long id) throws Exception {
		return discRepo.findById(id).orElse(null);
	}

	@Override
	public Discount findByDiscCode(String discCode) throws Exception {
		return discRepo.findByDiscCode(discCode);
	}

	@Override
	public Discount update(Discount disc) throws Exception {
		discRepo.save(disc);
		return disc;
	}
}
