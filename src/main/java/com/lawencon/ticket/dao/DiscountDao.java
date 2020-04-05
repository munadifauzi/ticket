package com.lawencon.ticket.dao;

import java.util.List;

import com.lawencon.ticket.model.Discount;

public interface DiscountDao {

	List<Discount> findAll() throws Exception;

	Discount save(Discount disc) throws Exception;

	void deleteById(Long id) throws Exception;

	Discount findByid(Long id) throws Exception;
	
	Discount findByDiscCode(String discCode) throws Exception;
	
	Discount update(Discount disc) throws Exception;
}
