package com.cv.tech.framework.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cv.tech.framework.document.AppUser;
import com.cv.tech.framework.mongorepository.AppUserRepository;
import com.cv.tech.framework.value.UserValue;

@Service
public class AppUserDetailsService implements UserDetailsService {
	private Logger logger = Logger.getLogger(AppUserDetailsService.class);

	@Autowired
	private AppUserRepository appUserRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userId)
			throws UsernameNotFoundException {
		logger.info("---------------- Start loadByUserName 19832748174 ---------------- ");
		logger.info("USERID PASSED : " + userId);
		UserValue userValue = null;
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

		AppUser appUser = null;

		appUser = appUserRepository.findByUserId(userId);
		grantedAuthorities.add(new SimpleGrantedAuthority(appUser.getAppRole().getName()));
		logger.info("ROLE NAME : " + appUser.getAppRole().getName());
		userValue = new UserValue(appUser.getId(), appUser.getUserId(), appUser.getPassword(), grantedAuthorities, appUser.getFirstName(), appUser.getLastName());
		logger.info("USER VALUE RETRIEVED FROM DB:  " + userValue);
		logger.info("---------------- End loadByUserName ---------------- ");
		return userValue;
	}

}
