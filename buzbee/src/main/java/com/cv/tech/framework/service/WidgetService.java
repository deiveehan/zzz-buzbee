package com.cv.tech.framework.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cv.tech.framework.document.AppUserWidgets;
import com.cv.tech.framework.document.Widget;
import com.cv.tech.framework.exception.ApplicationException;
import com.cv.tech.framework.mongorepository.AppUserWidgetsRepository;
import com.cv.tech.framework.mongorepository.WidgetRepository;
import com.cv.tech.framework.value.WidgetValue;

@Service
public class WidgetService {
	Logger logger = Logger.getLogger(WidgetService.class);
	
	@Autowired
	private WidgetRepository widgetRepository;
	
	@Autowired
	private AppUserWidgetsRepository appUserWidgetsRepository;

	@Autowired
	Environment environment;
	

	public List<Widget> getAllWidgets() {
		return widgetRepository.findAll();
	}

	public List<Widget> getWidgetsForUser(String userPID) {
		List <AppUserWidgets> appUserWidgets = appUserWidgetsRepository.findByUserPID(userPID);
		List<Widget> widgets = getWidgets(appUserWidgets);
		return widgets;
	}
	

	
	private List<Widget> getWidgets(List<AppUserWidgets> appUserWidgets) {
		List<Widget> widgets = new ArrayList<Widget>();
		for (Iterator iterator = appUserWidgets.iterator(); iterator.hasNext();) {
			AppUserWidgets appUserWidgets2 = (AppUserWidgets) iterator.next();
			widgets.add(widgetRepository.findOne(appUserWidgets2.getWidgetPID()));
		}
		return widgets;
	}

	public void save(WidgetValue widgetValue) {
		if (widgetValue.getId() == null || widgetValue.getId().equals("")) {
			widgetValue.setId(null);
		}
		Widget widget = convertWidgetValueToWidget(widgetValue);
		// Store the thumbnail and get the location
		String thumbnailUrl = updloadFile(widgetValue.getThumbnailFile());
		widget.setThumbnailUrl(thumbnailUrl);

		// Store the xml and get the location
		String screenshotUrl = updloadFile(widgetValue.getScreenshotFile());
		widget.setScreenshotUrl(screenshotUrl);
		// Store the screenshot and get the location
		String widgetURL = updloadFile(widgetValue.getWidgetFile());
		widget.setWidgetURL(widgetURL);

		// Save the widget
		widgetRepository.save(widget);
	}

	public String updloadFile(CommonsMultipartFile commonsMultipartFile) {

		String gadgetFilesRootFolder = environment
				.getProperty("gadgetFilesRootFolder");
		String gadgetFilesRootURL = environment
				.getProperty("gadgetFilesRootURL");
		String fileName = gadgetFilesRootFolder + "/" 
				+ commonsMultipartFile.getOriginalFilename();
		logger.info("File name to be saved: " + fileName);
		String fileURL = gadgetFilesRootURL + "/"
				+ commonsMultipartFile.getOriginalFilename();
		logger.info("File url to be used: " + fileURL);
		try {
			File file = new File(fileName);
			commonsMultipartFile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApplicationException("Could not upload file:"
					+ commonsMultipartFile.getOriginalFilename(),
					e.getMessage());
		}

		return fileURL;
	}

	private Widget convertWidgetValueToWidget(WidgetValue widgetValue){
		Widget widget = new Widget();
		widget.setId(widgetValue.getId());
		widget.setAppUser(widgetValue.getAppUser());
		widget.setDescription(widgetValue.getDescription());
		widget.setTitle(widgetValue.getTitle());
		widget.setUserPID(widgetValue.getUserPID());
		widget.setScreenshotUrl(widgetValue.getScreenshotUrl());
		widget.setThumbnailUrl(widgetValue.getThumbnailUrl());
		widget.setWidgetURL(widgetValue.getWidgetURL());
		return widget;
	}
	
	public String subscribeWidget(AppUserWidgets appUserWidgets) {
		String message = null;
		AppUserWidgets appUserWidgetsEntity = appUserWidgetsRepository.findByUserPIDAndWidgetPID(appUserWidgets.getUserPID(), appUserWidgets.getWidgetPID());
		if(appUserWidgetsEntity != null) {
			message = "You have ALREADY subscribed for this widget";
			logger.info("Widget "+ appUserWidgets.getWidgetPID() + " ALREADY SUBSCRIBED for userPID " + appUserWidgets.getUserPID());
		} else {
			message = "Widget subscribed";
			appUserWidgetsRepository.save(appUserWidgets);	
		}
		return message;
	}

	public String unsubscribe(AppUserWidgets appUserWidgets) {
		String message = null;
		AppUserWidgets appUserWidgetsEntity = appUserWidgetsRepository.findByUserPIDAndWidgetPID(appUserWidgets.getUserPID(), appUserWidgets.getWidgetPID());
		if(appUserWidgetsEntity != null) {
			appUserWidgetsRepository.delete(appUserWidgetsEntity);
			message = "Widget unsubscribed";
		} else {
			message = "You have to subscribe widget first to unsubscribe";
			logger.info("Widget "+ appUserWidgets.getWidgetPID() + " is NOT SUBSCRIBED for userPID " + appUserWidgets.getUserPID());
		}
		return message;
	}
}
