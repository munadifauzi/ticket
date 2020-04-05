package com.lawencon.ticket.service;

import java.util.List;

import com.lawencon.ticket.model.Discount;

public interface DiscountService {

	List<Discount> findAll(String string, String string2) throws Exception;

	Discount save(Discount disc, String string, String string2) throws Exception;

	void deleteById(Long id, String string, String string2) throws Exception;
	
	Discount findByDiscCode(String discCode, String string, String string2) throws Exception;
	
	Discount update(Discount disc, String string, String string2) throws Exception;

}
