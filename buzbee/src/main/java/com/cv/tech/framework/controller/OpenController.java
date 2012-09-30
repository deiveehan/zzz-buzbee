package com.cv.tech.framework.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cv.tech.framework.document.AppUser;
import com.cv.tech.framework.service.UserService;
import com.cv.tech.framework.value.MessageValue;

@Controller
@RequestMapping(value="open")
public class OpenController extends BaseController {

	private static Logger logger = Logger.getLogger(OpenController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value="/openhome", method=RequestMethod.GET)
	public String loadLoginPage(Model model) {
		logger.info("loading home");
		AppUser appUser = new AppUser();
		model.addAttribute("appUser", appUser);
		return "tech/openhome";
	}
	@RequestMapping(value="/mcetry", method=RequestMethod.GET)
	public String mcetry() {
		logger.info("loading mcetry");
		return "tech/mcetry";
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model) {
		logger.info("Logged out...");
		AppUser appUser = new AppUser();
		model.addAttribute("appUser", appUser);
		return "tech/openhome";
	}

/*	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String loadSignupPage(Model model) {
		logger.info("loading signup page");
		AppUser appUser = new AppUser();
		model.addAttribute("appUser", appUser);
		return "open/signup";
	}*/

	@RequestMapping(value = "/createUser", method=RequestMethod.POST)
	public @ResponseBody MessageValue createUser(AppUser appUser) {
		AppUser appUserInDB = userService.getUserByUserID(appUser.getUserId());
		MessageValue messageValue = new MessageValue();
		logger.info("App USer in db value : " + appUserInDB);
		System.out.println("Creating user : " + appUser.getFirstName());
		if(appUserInDB == null) {
			userService.signup(appUser);
			messageValue.setMessage("User " +appUser.getUserId()+ " has been created. Please sign in now");
		}
		else {
			messageValue.setMessage("User with " +appUser.getUserId()+ " already exists");
		}
		System.out.println("Message : " + messageValue.getMessage());
		return messageValue;
	}

	@RequestMapping(value="/loginFailed")
	public String loadLoginFailedPage(Model model) {
		logger.info("loading home");
		AppUser appUser = new AppUser();
		model.addAttribute("appUser", appUser);
		return "tech/openhome";
	}
}
