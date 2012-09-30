package com.cv.tech.framework.exception;

public class ApplicationException extends RuntimeException {
	
	private String message;
	private String detailedMessage;
	
	public ApplicationException() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ApplicationException(String message, String detailedMessage) {
		super();
		this.message = message;
		this.detailedMessage = detailedMessage;
	}


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetailedMessage() {
		return detailedMessage;
	}
	public void setDetailedMessage(String detailedMessage) {
		this.detailedMessage = detailedMessage;
	}
	@Override
	public String toString() {
		return "ApplicationException [message=" + message
				+ ", detailedMessage=" + detailedMessage + "]";
	}
}
