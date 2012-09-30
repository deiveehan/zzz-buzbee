package com.cv.tech.framework.mongorepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cv.tech.framework.document.AppUserWidgets;

public interface AppUserWidgetsRepository extends MongoRepository<AppUserWidgets, String> {
	public List<AppUserWidgets> findByUserPID(String userPID);
	public AppUserWidgets findByUserPIDAndWidgetPID(String userPID, String widgetPID);
}
