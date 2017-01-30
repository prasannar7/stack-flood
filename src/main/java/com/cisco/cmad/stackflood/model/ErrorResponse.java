package com.cisco.cmad.stackflood.model;

public class ErrorResponse {
	
	protected Integer httpStatusCode;
	protected String httpStatusMessage;
	
	public ErrorResponse() {
		super();
	}

	public ErrorResponse(Integer httpStatusCode, String httpStatusMessage) {
		super();
		this.httpStatusCode = httpStatusCode;
		this.httpStatusMessage = httpStatusMessage;
	}

	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(Integer httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getHttpStatusMessage() {
		return httpStatusMessage;
	}

	public void setHttpStatusMessage(String httpStatusMessage) {
		this.httpStatusMessage = httpStatusMessage;
	}

}
