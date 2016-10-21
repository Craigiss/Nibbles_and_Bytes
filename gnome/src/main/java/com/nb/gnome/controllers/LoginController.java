package com.nb.gnome.controllers;


import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.service.LoginService;
import com.nb.gnome.service.UserCredentials;

import java.io.Serializable;

@Named("login")
@SessionScoped
public class LoginController implements Serializable {
	@Inject
	LoginService loginService;
	@Inject
	UserCredentials userCredentials;
	private String email;
	private String password;
	private String error;

	
	public String login(){
		if(email.equals("")){
			setError("Please Enter a Email address");
			return "loginPage";
		}
		if(password.equals("")){
			setError("Please Enter a Password");
			return "loginPage";
		}
		
		if(!loginService.validateDetails(email, password)){
			setError("Invalid Email or Password");
			password = "";
			return "loginPage";
		}
		userCredentials.setEmail(email);
		userCredentials.setUser(loginService.getName(email));
		userCredentials.setId(loginService.getID(email));
		return "account";
	}
	
	public String logout(){
		userCredentials.setUser(null);
		userCredentials.setEmail(null);
		return "homePage";
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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	

	
}
