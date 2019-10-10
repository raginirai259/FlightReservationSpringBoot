package com.online.flight.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login {
	@NotNull(message="UserId must not be blank")
	@Size(min=4,max=15,message="UserId must be between 4 to 15 Characters.")
	private String userName;
	
	@NotNull(message="password must not be blank")
	@Size(min=8,max=15,message="password must be between 8 to 15 Characters.")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
