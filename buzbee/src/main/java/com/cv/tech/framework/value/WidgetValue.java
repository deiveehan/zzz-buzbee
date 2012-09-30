package com.cv.tech.framework.value;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cv.tech.framework.document.AppUser;

public class WidgetValue {
	private String id;
	private String title; 
	private String widgetURL;
	private String thumbnailUrl;
	private String screenshotUrl;
	private String userPID;
	@DBRef
	private AppUser appUser;
	
	private String description;
	
	private transient CommonsMultipartFile widgetFile;
	private transient CommonsMultipartFile thumbnailFile;
	private transient CommonsMultipartFile screenshotFile;
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
	public CommonsMultipartFile getWidgetFile() {
		return widgetFile;
	}
	public void setWidgetFile(CommonsMultipartFile widgetFile) {
		this.widgetFile = widgetFile;
	}
	public CommonsMultipartFile getThumbnailFile() {
		return thumbnailFile;
	}
	public void setThumbnailFile(CommonsMultipartFile thumbnailFile) {
		this.thumbnailFile = thumbnailFile;
	}
	public CommonsMultipartFile getScreenshotFile() {
		return screenshotFile;
	}
	public void setScreenshotFile(CommonsMultipartFile screenshotFile) {
		this.screenshotFile = screenshotFile;
	}
	public AppUser getAppUser() {
		return appUser;
	}
	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	@Override
	public String toString() {
		return "WidgetValue [id=" + id + ", title=" + title + ", widgetURL="
				+ widgetURL + ", thumbnailUrl=" + thumbnailUrl
				+ ", screenshotUrl=" + screenshotUrl + ", userPID=" + userPID
				+ ", description=" + description
				+ ", widgetFile=" + widgetFile + ", thumbnailFile="
				+ thumbnailFile + ", screenshotFile=" + screenshotFile + "]";
	}
	
	
}
