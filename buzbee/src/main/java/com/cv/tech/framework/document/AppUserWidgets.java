package com.cv.tech.framework.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AppUserWidgets {
	private String id;
	private String userPID;
	private String widgetPID;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserPID() {
		return userPID;
	}
	public void setUserPID(String userPID) {
		this.userPID = userPID;
	}
	public String getWidgetPID() {
		return widgetPID;
	}
	public void setWidgetPID(String widgetPID) {
		this.widgetPID = widgetPID;
	}
	@Override
	public String toString() {
		return "AppUserWidgets [id=" + id + ", userPID=" + userPID
				+ ", widgetPID=" + widgetPID + "]";
	}
}
