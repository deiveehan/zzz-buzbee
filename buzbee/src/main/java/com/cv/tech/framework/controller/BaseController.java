package com.cv.tech.framework.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cv.tech.framework.document.AppUser;
import com.cv.tech.framework.exception.ApplicationException;
import com.cv.tech.framework.service.UserService;
import com.cv.tech.framework.value.ErrorValue;


public class BaseController {
	private Logger logger = Logger.getLogger(BaseController.class);

	@Autowired
	UserService userService;

	@ExceptionHandler(ApplicationException.class)
	 public @ResponseBody ErrorValue handleApplicationException(ApplicationException r, HttpServletResponse response) {
		logger.info("Inside handleApplicationException" );
		ErrorValue errorValue = new ErrorValue(r.getMessage(), r.getDetailedMessage(), r.toString());
		//response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		r.printStackTrace();
        return errorValue;
    }

	@ExceptionHandler(RuntimeException.class)
	 public @ResponseBody ErrorValue handleRuntimeException(RuntimeException r, HttpServletResponse response) {
		logger.info("Inside handleApplicationException" );
		ErrorValue errorValue = new ErrorValue(r.getMessage(), r.getMessage(), r.toString());
		//response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		r.printStackTrace();
        return errorValue;
    }
/*	@ExceptionHandler(Exception.class)
	 public @ResponseBody ErrorValue handleException(RuntimeException r, HttpServletResponse response) {
		logger.info("Inside handleException" );
		ErrorValue errorValue = new ErrorValue(r.getMessage(), r.getMessage(), r.toString());
//		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		r.printStackTrace();
       return errorValue;
   }*/
	
	
	public String getCurrentUserPID() {
		return userService.getCurrentUserPID();
	}

	public AppUser getCurrentAppUser() {
		return userService.getCurrentAppUser();
	}

}
