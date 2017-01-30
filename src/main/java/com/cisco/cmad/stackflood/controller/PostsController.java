package com.cisco.cmad.stackflood.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cisco.cmad.stackflood.api.Post;
import com.cisco.cmad.stackflood.model.PostDetails;
import com.cisco.cmad.stackflood.service.PostImpl;

@Path("/posts")
public class PostsController {
	
	@Context
    private HttpServletResponse servletResponse;
	
	@Context
	private HttpServletRequest servletRequest;
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response fetch(){
		Post post = new PostImpl();
		List<PostDetails> postDetailsList = post.fetch();
		return Response.ok().entity(postDetailsList).build();
	}

}
