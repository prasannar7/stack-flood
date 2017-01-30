package com.cisco.cmad.stackflood.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cisco.cmad.stackflood.model.ErrorResponse;

@Provider
public class PostExceptionHandler implements ExceptionMapper<PostException>{

	public Response toResponse(PostException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setHttpStatusCode(exception.getHttpStatusCode());
		errorResponse.setHttpStatusMessage(exception.getHttpStatusMessage());
		return Response.status(exception.getHttpStatusCode()).entity(errorResponse).build();
	}

}
