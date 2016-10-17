package com.nb.gnome.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.service.CreateAccountService;

// Created by Cameron & Jacob

@Named(value="CreateAccount")
@RequestScoped
public class CreateAccountController {
	@Inject
	CreateAccountService createAccountService;
	
	private String firstName;
	private String surname;
	private String email;
	private String addressFirstLine;
	private String postcode;
	private String password;
	private String reenteredPassword;
	
	private String error;
	
	public String addUser(){	
		if(firstName.equals("")){							// Basic validation. If any fields empty return to login page.
			error = "Please enter your first name.";
			return "loginPage";
		}
		
		if(surname.equals("")){							// Basic validation. If any fields empty return to login page.
			error = "Please enter your surname.";
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
		
		createAccountService.newUser(firstName, surname, email, addressFirstLine, postcode, password);
		return "home";
		
		
	}
	
}
