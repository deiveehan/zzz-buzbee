package com.cv.tech.framework.document;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class Widget {
	private String id;
	private String title; 
	private String description;
	private String widgetURL;
	private String thumbnailUrl;
	private String screenshotUrl;
	private String userPID;
	@DBRef
	private AppUser appUser;
	
	public Widget() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Widget(String id, String title, String widgetURL,
			String thumbnailUrl, String screenshotUrl, String userPID,
			String description) {
		super();
		this.id = id;
		this.title = title;
		this.widgetURL = widgetURL;
		this.thumbnailUrl = thumbnailUrl;
		this.screenshotUrl = screenshotUrl;
		this.userPID = userPID;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWidgetURL() {
		return widgetURL;
	}
	public void setWidgetURL(String widgetURL) {
		this.widgetURL = widgetURL;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	public String getScreenshotUrl() {
		return screenshotUrl;
	}
	public void setScreenshotUrl(String screenshotUrl) {
		this.screenshotUrl = screenshotUrl;
	}
	public String getUserPID() {
		return userPID;
	}
	public void setUserPID(String userPID) {
		this.userPID = userPID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public AppUser getAppUser() {
		return appUser;
	}
	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	@Override
	public String toString() {
		return "Widget [id=" + id + ", title=" + title + ", widgetURL="
				+ widgetURL + ", thumbnailUrl=" + thumbnailUrl
				+ ", screenshotUrl=" + screenshotUrl + ", userPID=" + userPID
				+ ", description=" + description + "]";
	} 
}
