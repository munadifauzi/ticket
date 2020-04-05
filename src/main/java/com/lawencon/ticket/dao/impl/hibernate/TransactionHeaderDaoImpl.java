package com.lawencon.ticket.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import com.lawencon.ticket.dao.TransactionHeaderDao;
import com.lawencon.ticket.model.TransactionHeader;

@Repository("transHeader_repo_hibernate")
public class TransactionHeaderDaoImpl extends BaseHibernate implements TransactionHeaderDao {

	@Override
	public TransactionHeader save(TransactionHeader transHeader) throws Exception {
		em.persist(transHeader);
		return transHeader;
	}

}
