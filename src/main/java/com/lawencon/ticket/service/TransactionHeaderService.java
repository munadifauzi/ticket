package com.lawencon.ticket.service;

import com.lawencon.ticket.model.Transaction;
import com.lawencon.ticket.model.TransactionHeader;

public interface TransactionHeaderService {

	TransactionHeader save(TransactionHeader transHeader, String auth, String auth2) throws Exception;
	
	void saveTransaction (Transaction transaction, String auth, String auth2) throws Exception;
}
