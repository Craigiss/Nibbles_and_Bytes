package com.nb.gnome.controllers;


import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.service.LoginService;

@Named("login")
public class LoginController {
	@Inject
	LoginService loginService;
	
	private String email;
	private String password;
	private String error;
	
	public String login(){
		if(email.equals("")){
			return("loginPage");
		}
		if(password.equals("")){
			return("loginPage");
		}
		
		if(!loginService.validateDetails(email, password)){
			error = "Invalid Input";
			password = "";
			return "loginPage";
		}
		return("homepage");
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	

	
}
