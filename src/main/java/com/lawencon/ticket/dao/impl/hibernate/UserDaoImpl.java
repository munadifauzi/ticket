package com.lawencon.ticket.dao.impl.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.ticket.dao.UserDao;
import com.lawencon.ticket.model.User;

@Repository("user_repo_hibernate")
public class UserDaoImpl extends BaseHibernate implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() throws Exception {
		Query q = em.createQuery("from User");
		List<User> listUser = new ArrayList<>();
		listUser = q.getResultList();
		return listUser;
	}

	@Override
	public User save(User user) throws Exception {
		em.persist(user);
		return user;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		Query q = em.createQuery(" from User where idUser = :idParam");
		q.setParameter("idParam", id);

		User user = new User();
		user = (User) q.getSingleResult();
		em.remove(user);

	}

	@Override
	public User findByid(Long id) throws Exception {
		Query q = em.createQuery(" from User where idUser = :idParam");
		q.setParameter("idParam", id);

		User user = new User();
		user = (User) q.getSingleResult();
		return user;
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) throws Exception {
		Query q = em.createQuery(" from User where userName = :userNameParam and password= :passwordParam");
		q.setParameter("userNameParam", userName);
		q.setParameter("passwordParam", password);

		User user = (User) q.getSingleResult();
		return user;
	}

	@Override
	public User update(User user) throws Exception {
		em.merge(user);
		return user;
	}

}
