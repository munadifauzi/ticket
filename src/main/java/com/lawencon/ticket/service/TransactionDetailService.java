package com.lawencon.ticket.service;

import java.util.List;

import com.lawencon.ticket.model.TransactionDetail;

public interface TransactionDetailService {

	List<TransactionDetail> save(List<TransactionDetail> listTranssaction, String auth, String auth2) throws Exception;

}
