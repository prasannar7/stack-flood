package com.cisco.cmad.stackflood.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Credentials {

	protected String userName;
	protected String password;
	
	public Credentials() {
		super();
	}

	public Credentials(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
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
	
}
