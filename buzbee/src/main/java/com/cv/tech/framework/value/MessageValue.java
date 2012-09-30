package com.cv.tech.framework.value;

import java.io.Serializable;

public class MessageValue implements Serializable {
	private String message;
	private String detailedMessage;

	private Object object;

	public MessageValue() {
	}

	public MessageValue(String message) {
		super();
		this.message = message;
	}
	public MessageValue(String message, String detailedMessage) {
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
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
}
