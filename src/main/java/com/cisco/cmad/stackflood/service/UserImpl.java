package com.cisco.cmad.stackflood.service;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import com.cisco.cmad.stackflood.api.User;
import com.cisco.cmad.stackflood.data.dao.BaseJPADao;
import com.cisco.cmad.stackflood.data.dao.UserDaoImpl;
import com.cisco.cmad.stackflood.exception.UserException;
import com.cisco.cmad.stackflood.model.Credentials;
import com.cisco.cmad.stackflood.model.UserDetails;

public class UserImpl implements User{
	
	private static BaseJPADao baseJPADao;

	public UserImpl() {
		baseJPADao = new UserDaoImpl();
	}

	public UserDetails authenticate(Credentials credentials) {
		UserDetails userDetails = null;
		try {
			userDetails = ((UserDaoImpl) baseJPADao).authenticate(credentials.getUserName(), credentials.getPassword());
		} catch (Exception e) {
			if(e instanceof NoResultException){
				throw new UserException(new Integer(401), "Unauthrized:Please check username and password");
			}else{
				throw new UserException(new Integer(500), e.getMessage());
			}
		}
		userDetails.setPassword("");
		return userDetails;
	}

	public UserDetails add(UserDetails userDetails) {
		UserDetails userDetailsResult = null;
		try {
			userDetailsResult = ((UserDaoImpl) baseJPADao).create(userDetails);
			if (userDetailsResult == null)
				throw new UserException(new Integer(400), "Bad request");
		} catch (Exception e) {
			if(e instanceof PersistenceException){
				throw new UserException(new Integer(600), "User already exists, please check your username.");
			}else{
				throw new UserException(new Integer(500), e.getMessage());
			}
		}
		return userDetailsResult;
	}

	public UserDetails fetch(String userName) {
		UserDetails userDetailsResult = null;
		try {
			userDetailsResult = ((UserDaoImpl) baseJPADao).read(userName);
			if (userDetailsResult == null)
				throw new UserException(new Integer(404), "User not found");
		} catch (Exception e) {
				throw new UserException(new Integer(500), e.getMessage());
			
		}
		return userDetailsResult;
	}

}
