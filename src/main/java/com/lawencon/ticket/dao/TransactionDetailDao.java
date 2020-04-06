package com.lawencon.ticket.dao;

import java.util.List;

import com.lawencon.ticket.model.TransactionDetail;

public interface TransactionDetailDao {

	List<TransactionDetail> save(List<TransactionDetail> listTransaction) throws Exception;

}
