package com.lawencon.ticket.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import com.lawencon.ticket.dao.TransactionDetailDao;
import com.lawencon.ticket.model.TransactionDetail;

@Repository("transDetail_repo_hibernate")
public class TransactionDetailDaoImpl extends BaseHibernate implements TransactionDetailDao {

	@Override
	public TransactionDetail save(TransactionDetail transDetail) throws Exception {
		em.persist(transDetail);
		return transDetail;
	}

}
