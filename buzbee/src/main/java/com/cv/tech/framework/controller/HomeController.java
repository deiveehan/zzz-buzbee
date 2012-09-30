package com.cv.tech.framework.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cv.tech.framework.value.UserValue;

@Controller
@RequestMapping(value="home")
public class HomeController {
	private static Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value="/in", method = RequestMethod.GET)
	public String goHome(Model model) {
/*		UserValue userValue = (UserValue)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.info("User value obtained from security context : " + userValue);
		model.addAttribute("userValue", userValue);*/
		return "tech/home";
	}
}
