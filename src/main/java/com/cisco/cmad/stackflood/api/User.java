package com.cisco.cmad.stackflood.api;

import com.cisco.cmad.stackflood.model.Credentials;
import com.cisco.cmad.stackflood.model.UserDetails;

public interface User {
	
	public UserDetails authenticate(Credentials credentials);
	
	public UserDetails add(UserDetails userDetails);
	
	public UserDetails fetch(String userName);

}
