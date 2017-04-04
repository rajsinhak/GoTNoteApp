package com.gotprint.noteapp.model;


import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Raj Kamal
 * @since 04/04/2017
 * UserContext Class to pass the user detail.
 * In case of Role Based Authorization this class can be utilized
 *
 */
public class UserContext {
	private final String username;

	private UserContext(String username) {
		this.username = username;
	}

	public static UserContext create(String username) {
		if (StringUtils.isBlank(username))
			throw new IllegalArgumentException("Username is blank: " + username);
		return new UserContext(username);
	}

	public String getUsername() {
		return username;
	}
}
