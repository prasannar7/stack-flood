package com.cisco.cmad.stackflood.data.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseJPADao {

	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("stackflood");
	
	public BaseJPADao() {
		
	}

}
