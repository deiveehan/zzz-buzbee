package com.cv.tech.framework.value;

import java.io.Serializable;

public class ErrorValue implements Serializable {
	private String message;
	private String detailedMessage;
	private String stackTrace;
	private String ERROR;

	public ErrorValue(String message, String detailedMessage, String stackTrace) {
		super();
		this.ERROR="TRUE";
		this.message = message;
		this.detailedMessage = detailedMessage;
		this.stackTrace = stackTrace;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStackTrace() {
		return stackTrace;
	}
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public String getDetailedMessage() {
		return detailedMessage;
	}

	public void setDetailedMessage(String detailedMessage) {
		this.detailedMessage = detailedMessage;
	}

	public String getERROR() {
		return ERROR;
	}

	public void setERROR(String eRROR) {
		ERROR = eRROR;
	}
	
	


}
