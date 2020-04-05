package com.lawencon.ticket.dao.impl.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.ticket.dao.TransactionDetailDao;
import com.lawencon.ticket.model.TransactionDetail;

@Repository("transDetail_repo_jpa")
public class TransactionDetailDaoImpl implements TransactionDetailDao {

	@Autowired
	TransactionDetailRepo transDetailRepo;
	
	@Override
	public TransactionDetail save(TransactionDetail transDetail) throws Exception {
		return transDetailRepo.save(transDetail);
	}

}
