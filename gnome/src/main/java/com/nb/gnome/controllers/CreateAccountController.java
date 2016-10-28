package com.nb.gnome.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.service.CreateAccountService;
import com.nb.gnome.service.LoginService;
import com.nb.gnome.service.UserCredentials;

// Created by Cameron & Jacob

@Named(value="CreateAccount")
@RequestScoped
public class CreateAccountController {
	@Inject
	CreateAccountService createAccountService;
	@Inject 
	LoginController loginController;
	@Inject 
	LoginService loginService; 
	@Inject 
	UserCredentials userCredentials; 
	
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
			setError("Please enter your First Name.");
			return "loginPage";
		}
		
		if(surname.equals("")){							// Basic validation. If any fields empty return to login page.
			setError("Please enter your Surname.");
			return "loginPage";
		}
		if(addressFirstLine.equals("")){
			setError("Please enter the first line of your address.");
			return "loginPage";
		}

		if(postcode.equals("")){
			setError("Please enter your Postcode");
			return "loginPage";
		}
		
		if(email.equals("")){
			setError("Please enter your Email.");
			return "loginPage";
		}
		
		if(password.equals("")){
			setError("Please enter your Password.");
			return "loginPage";
		}
		
		if(reenteredPassword.equals("")){
			setError("Please confirm your Password.");
			return "loginPage";
		}
		
		if(password.equals(reenteredPassword)==false){
			setError("Passwords do not match.");
			return "loginPage";
		}
		
		createAccountService.newUser(firstName, surname, email, addressFirstLine, postcode, password);
		String outcome  = login();
		return outcome;
		
		
	}

	/**
	 * @return the createAccountService
	 */
	public CreateAccountService getCreateAccountService() {
		return createAccountService;
	}

	/**
	 * @param createAccountService the createAccountService to set
	 */
	public void setCreateAccountService(CreateAccountService createAccountService) {
		this.createAccountService = createAccountService;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the addressFirstLine
	 */
	public String getAddressFirstLine() {
		return addressFirstLine;
	}

	/**
	 * @param addressFirstLine the addressFirstLine to set
	 */
	public void setAddressFirstLine(String addressFirstLine) {
		this.addressFirstLine = addressFirstLine;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the reenteredPassword
	 */
	public String getReenteredPassword() {
		return reenteredPassword;
	}

	/**
	 * @param reenteredPassword the reenteredPassword to set
	 */
	public void setReenteredPassword(String reenteredPassword) {
		this.reenteredPassword = reenteredPassword;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	public String login(){
		if(email.equals("")){
			return "loginPage";
		}
		if(password.equals("")){
			return "loginPage";
		}
		
		if(!loginService.validateDetails(email, password)){
			error = "Invalid Input";
			password = "";
			return "loginPage";
		}
		userCredentials.setEmail(email);
		userCredentials.setUser(loginService.getName(email));
		return "homePage";
	}
	
}