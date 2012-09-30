package com.cv.tech.framework.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cv.tech.framework.document.AppUser;
import com.cv.tech.framework.mongorepository.AppUserRepository;
import com.cv.tech.framework.service.UserService;
import com.cv.tech.framework.value.MessageValue;

@Controller
@RequestMapping(value = "user")
public class UserController extends BaseController {
	private Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	AppUserRepository appUserDocRepository;

	@Autowired
	UserService userService;

/*	@RequestMapping(value = "/edit/{id}")
	public String loadEditPage(@PathVariable(value = "id") String id, Model model) {
		AppUser appUser = appUserDocRepository.findOne(id);
		model.addAttribute("appUser", appUser);
		return "user/userEdit";
	}

	@RequestMapping(value = "/edit")
	public String loadEditPageForCurrentUser(Model model) {

		AppUser appUser = appUserDocRepository.findOne(getCurrentUserPID());
		model.addAttribute("appUser", appUser);
		return "user/userEdit";
	}*/

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@Transactional
	public @ResponseBody MessageValue save(AppUser appUser) {
		logger.info("First name : " + appUser.toString());
		userService.save(appUser);

		MessageValue messageValue = new MessageValue("Your information has been updated !!");
		return messageValue;
	}


}