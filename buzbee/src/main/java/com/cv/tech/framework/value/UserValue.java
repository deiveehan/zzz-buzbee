package com.cv.tech.framework.value;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserValue extends User {

	private String id;
	private String userId;
	private String firstName;
	private String lastName;
	private String password;

	private static final boolean accountNonExpired = true;
	private static final boolean credentialsNonExpired = true;
	private static final boolean accountNonLocked = true;
	private static final boolean enabled = true;

	public UserValue(String id, String userId, String password,
			Collection<? extends GrantedAuthority> authorities,
			String firstName, String lastName) {
		super(userId, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		this.id=id;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password=password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserValue [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", password="
				+ password + "]";
	}
}
