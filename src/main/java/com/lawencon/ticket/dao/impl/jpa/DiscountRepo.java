package com.lawencon.ticket.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawencon.ticket.model.Discount;

public interface DiscountRepo extends JpaRepository<Discount, Long> {

	Discount findByDiscCode(String discCode) throws Exception;
}
