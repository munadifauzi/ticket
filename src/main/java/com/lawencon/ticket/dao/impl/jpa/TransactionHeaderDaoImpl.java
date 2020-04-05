package com.lawencon.ticket.dao.impl.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.ticket.dao.TransactionHeaderDao;
import com.lawencon.ticket.model.TransactionHeader;

@Repository("transHeader_repo_jpa")
public class TransactionHeaderDaoImpl implements TransactionHeaderDao{

	@Autowired
	TransactionHeaderRepo transHeaderRepo;
	
	@Override
	public TransactionHeader save(TransactionHeader transHeader) throws Exception {
		transHeaderRepo.save(transHeader);
		return transHeader;
	}

}
