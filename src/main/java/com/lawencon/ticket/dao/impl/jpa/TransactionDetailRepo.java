package com.lawencon.ticket.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawencon.ticket.model.TransactionDetail;

public interface TransactionDetailRepo extends JpaRepository<TransactionDetail, Long> {

}
