package com.cv.tech.framework.util;

public enum UserRole {
	USER("USER"), DEVELOPER("DEVELOPER"), ADMIN("ADMIN");
	private String roleName;

	private UserRole(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
