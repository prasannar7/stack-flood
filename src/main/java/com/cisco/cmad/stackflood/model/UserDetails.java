package com.cisco.cmad.stackflood.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="UserDetails")
public class UserDetails {
	
	@Id
	protected String userName;
	protected String password;
	protected String email;
	protected String phoneNumber;
	
	public UserDetails() {
		super();
	}

	public UserDetails(String userName, String password, String email, String phoneNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
