package com.nb.gnome.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

// Created by Cameron & Jacob

@Named(value="CreateAccount")
@RequestScoped
public class CreateAccountController {
	@Inject
	CreateAccountService createAccountService;
	@Inject
	NewAccountCredentials newAccountCredentials;
	
	private String name;
	private String email;
	private String addressFirstLine;
	private String postcode;
	private String password;
	private String reenteredPassword;
	
	private String error;
	
	public String addUser(){	
		if(name.equals("")){							// Basic validation. If any fields empty return to login page.
			error = "Please enter your name.";
			return "loginPage";
		}
		if(email.equals("")){
			error = "Please enter your email.";
			return "loginPage";
		}
		if(addressFirstLine.equals("")){
			error = "Please enter the first line of your address.";
			return "loginPage";
		}
		if(postcode.equals("")){
			error = "Please enter your postcode";
			return "loginPage";
		}
		if(password.equals("")){
			error = "Please enter your password.";
			return "loginPage";
		}
		
		if(reenteredPassword.equals("")){
			error = "Please confirm your password.";
			return "loginPage";
		}
		
		if(password.equals(reenteredPassword)==false){
			error = "Passwords do not match.";
			return "loginPage";
		}
	}
	
}
