package com.cv.tech.framework.service;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cv.tech.framework.document.AppRole;
import com.cv.tech.framework.document.AppUser;
import com.cv.tech.framework.mongorepository.AppRoleRepository;
import com.cv.tech.framework.mongorepository.AppUserRepository;
import com.cv.tech.framework.util.UserRole;
import com.cv.tech.framework.value.UserValue;

@Service
public class UserService {
	Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	AppUserRepository appUserRepository;

	@Autowired
	AppRoleRepository appRoleRepository;

	@Autowired
	Environment environment;

	@Transactional
	public AppUser signup(AppUser appUser) {
		logger.info("user role : " + UserRole.USER.getRoleName());
		AppRole appRole = appRoleRepository.findByName(UserRole.USER
				.getRoleName());
		logger.info("appRole : " + appRole);
		appRole.setName(UserRole.USER.getRoleName());
		appUser.setAppRole(appRole);
		AppUser appUserUpdated = appUserRepository.save(appUser);

		String epubRoot = environment.getProperty("epubFilesRootFolder");
		logger.info("epub root folder: " + epubRoot);
		String userEpubDirectory = epubRoot + "/" + appUserUpdated.getId();
		System.out.println("user epubzz root folder (SOP): "
				+ userEpubDirectory);
		logger.info("userEpubDirectory root folder (logger): "
				+ userEpubDirectory);
		File dir = new File(userEpubDirectory);
		// dir.createNewFile();
		dir.mkdir();
		return appUserUpdated;
	}

	@Transactional
	public AppUser save(AppUser appUserDoc) {
		AppRole appRole = appUserRepository.findOne(appUserDoc.getId())
				.getAppRole();
		if (appRole != null) {
			appUserDoc.setAppRole(appRole);
			logger.info("user role of the user to be saved : "
					+ appRole.getName());
		}
		appUserRepository.save(appUserDoc);
		return appUserDoc;
	}

	@Transactional
	public void removeUserFromSystem(String userPID) {
		appUserRepository.delete(userPID);

	}

	public AppUser getCurrentAppUser() {
		AppUser appUser = appUserRepository.findOne(getCurrentUserPID());
		return appUser;
	}

	public UserValue getCurrentUserValue() {
		UserValue userValue = (UserValue) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		return userValue;
	}

	public String getCurrentUserPID() {
		UserValue userValue = (UserValue) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		return userValue.getId();
	}

	public AppUser getUserByUserID(String userId) {
		return appUserRepository.findByUserId(userId);
	}
}