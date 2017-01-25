package com.cisco.cmad.stackflood.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cisco.cmad.stackflood.api.User;
import com.cisco.cmad.stackflood.model.Credentials;
import com.cisco.cmad.stackflood.model.SuccessResponse;
import com.cisco.cmad.stackflood.model.UserDetails;
import com.cisco.cmad.stackflood.service.UserImpl;

@Path("/user")
public class UserController {

	@Context
    private HttpServletResponse servletResponse;
	
	@Context
	private HttpServletRequest servletRequest;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/authenticate")
	public Response authenticate(@CookieParam("user-name") String userName,  Credentials credentials){
		User user = new UserImpl();
		UserDetails userDetails = user.authenticate(credentials);
		HttpSession session = servletRequest.getSession(true);
		session.setAttribute("user-name", credentials.getUserName());
		Cookie myCookie = new Cookie("user-name", credentials.getUserName());
	    myCookie.setMaxAge(60 * 60);
	    myCookie.setPath("/");
	    servletResponse.addCookie(myCookie);
	    return Response.ok().entity(userDetails).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/logout/{username}")
	public Response authenticate(@CookieParam("user-name") String cookieUserName,  @PathParam("username") String userName){
		servletRequest.getSession(false).invalidate();
		Cookie myCookie = new Cookie("user-name", userName);
        myCookie.setMaxAge(0);
        myCookie.setPath("/");
        servletResponse.addCookie(myCookie);
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setStatusCode(200);
        successResponse.setStatusMessage("User successfully logged out");
		return Response.ok().entity(successResponse).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response add(UserDetails userDetails){
		User user = new UserImpl();
		UserDetails userDetailsResponse = user.add(userDetails);
		return Response.ok().entity(userDetailsResponse).build();
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{username}")
	public Response fetch(@PathParam("username") String userName){
		User user = new UserImpl();
		UserDetails userDetails = user.fetch(userName);
		return Response.ok().entity(userDetails).build();
	}
	
}
