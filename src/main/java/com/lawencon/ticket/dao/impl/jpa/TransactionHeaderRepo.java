package com.lawencon.ticket.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawencon.ticket.model.TransactionHeader;

public interface TransactionHeaderRepo extends JpaRepository<TransactionHeader, Long> {

}
