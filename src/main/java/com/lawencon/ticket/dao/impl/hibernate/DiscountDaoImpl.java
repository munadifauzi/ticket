package com.lawencon.ticket.dao.impl.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.ticket.dao.DiscountDao;
import com.lawencon.ticket.model.Discount;

@Repository("disc_repo_hibernate")
public class DiscountDaoImpl extends BaseHibernate implements DiscountDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Discount> findAll() throws Exception {
		Query q = em.createQuery("from Discount");
		List<Discount> listDiscount = new ArrayList<>();
		listDiscount = q.getResultList();
		return listDiscount;
	}

	@Override
	public Discount save(Discount disc) throws Exception {
		em.persist(disc);
		return disc;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		Query q = em.createQuery(" from Discount where idDiscount = :idParam");
		q.setParameter("idParam", id);

		Discount disc = new Discount();
		disc = (Discount) q.getSingleResult();
		em.remove(disc);

	}

	@Override
	public Discount findByid(Long id) throws Exception {
		Query q = em.createQuery(" from Discount where idDiscount = :idParam");
		q.setParameter("idParam", id);

		Discount disc = new Discount();
		disc = (Discount) q.getSingleResult();
		return disc;
	}

	@Override
	public Discount findByDiscCode(String discCode) throws Exception {
		Query q = em.createQuery(" from Discount where discCode = :codeParam");
		q.setParameter("codeParam", discCode);

		Discount disc = new Discount();
		disc = (Discount) q.getSingleResult();
		return disc;
	}

	@Override
	public Discount update(Discount disc) throws Exception {
		em.merge(disc);
		return disc;
	}

}
