package com.lawencon.ticket.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.ticket.dao.TransactionDetailDao;
import com.lawencon.ticket.model.TransactionDetail;

@Repository("transDetail_repo_jpa")
public class TransactionDetailDaoImpl implements TransactionDetailDao {

	@Autowired
	TransactionDetailRepo transDetailRepo;
	
	@Override
	public List<TransactionDetail> save(List<TransactionDetail> listTransaction) throws Exception {
		return transDetailRepo.saveAll(listTransaction);
	}

}
