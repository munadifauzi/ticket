package com.lawencon.ticket.dao;

import com.lawencon.ticket.model.TransactionHeader;

public interface TransactionHeaderDao {

	TransactionHeader save(TransactionHeader transHeader) throws Exception;

}
