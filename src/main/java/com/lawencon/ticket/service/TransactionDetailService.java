package com.lawencon.ticket.service;

import com.lawencon.ticket.model.TransactionDetail;

public interface TransactionDetailService {

	TransactionDetail save(TransactionDetail transDetail, String auth, String auth2) throws Exception;

}
