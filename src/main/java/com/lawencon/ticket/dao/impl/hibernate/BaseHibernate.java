package com.lawencon.ticket.dao.impl.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseHibernate {

	@PersistenceContext
	protected EntityManager em;
}
