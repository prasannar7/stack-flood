package com.cisco.cmad.stackflood.data.api;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;

import com.cisco.cmad.stackflood.model.UserDetails;

public interface UserDao {
	
	public UserDetails read(String userName);
	
	public UserDetails create(UserDetails userDetails) throws PersistenceException;
	
	public UserDetails authenticate(String userName, String password) throws NoResultException, NonUniqueResultException;
	
}
