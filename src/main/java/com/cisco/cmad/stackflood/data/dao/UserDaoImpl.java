package com.cisco.cmad.stackflood.data.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;

import com.cisco.cmad.stackflood.data.api.UserDao;
import com.cisco.cmad.stackflood.model.UserDetails;

public class UserDaoImpl extends BaseJPADao implements UserDao{

	public UserDaoImpl() {
		super();
	}

	public UserDetails read(String userName) {
		EntityManager em = factory.createEntityManager();
		UserDetails userDetails = em.find(UserDetails.class, userName);
		em.close();
		return userDetails;
	}
	
	public UserDetails authenticate(String userName, String password) throws NoResultException, NonUniqueResultException{
		EntityManager em = factory.createEntityManager();
		UserDetails userDetails = (UserDetails) em.createQuery("from UserDetails u where u.userName = :uname AND u.password = :pwd").setParameter("uname", userName).setParameter("pwd", password).getSingleResult();
		em.close();
		return userDetails;
	}

	public UserDetails create(UserDetails userDetails) throws PersistenceException{
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(userDetails);
		em.getTransaction().commit();
		em.close();
		return userDetails;
	}

}
