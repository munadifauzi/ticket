package com.lawencon.ticket.dao.impl.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.ticket.dao.TransactionDetailDao;
import com.lawencon.ticket.model.TransactionDetail;

@Repository("transDetail_repo_hibernate")
public class TransactionDetailDaoImpl extends BaseHibernate implements TransactionDetailDao {

	@Override
	public List<TransactionDetail> save(List<TransactionDetail> listTransaction) throws Exception {
		em.persist(listTransaction);
		return listTransaction;
	}

}
