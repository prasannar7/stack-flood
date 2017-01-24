package com.cisco.cmad.stackflood.model;

public class SuccessResponse {
	
	protected int statusCode;
	protected String statusMessage;
	public SuccessResponse() {
		
	}
	
	public SuccessResponse(int statusCode, String statusMessage) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}	
	
}
