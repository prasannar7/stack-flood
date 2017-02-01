package com.cisco.cmad.stackflood.exception;

@SuppressWarnings("serial")
public class PostException extends BaseException{
	
	protected Integer httpStatusCode;
	protected String httpStatusMessage;

	public PostException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PostException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PostException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PostException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public PostException(Integer httpStatusCode, String httpStatusMessage) {
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
