package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Address;
import com.nb.gnome.managers.CustomerRepository;
import com.nb.gnome.service.UpdateAccountService;
import com.nb.gnome.service.UserCredentials;

@Named("Account")
@SessionScoped
public class AccountController implements Serializable {
	@Inject
	CustomerRepository accountManager;
	@Inject
	UserCredentials userCredentials;
	@Inject 
	UpdateAccountService updateAccountService;
	
	
	private List<Address> address;
    private String email; 
    private String firstName; 
    private String surname; 
    private String addressFirstLine;
    private String postcode;
    private String county; 
	
	/**
	 * @return the accountManager
	 */
	public CustomerRepository getAccountManager() {
		return accountManager;
	}

	/**
	 * @param accountManager the accountManager to set
	 */
	public void setAccountManager(CustomerRepository accountManager) {
		this.accountManager = accountManager;
	}

	/**
	 * @return the userCredentials
	 */
	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	/**
	 * @param userCredentials the userCredentials to set
	 */
	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

	/**
	 * @return the updateAccountService
	 */
	public UpdateAccountService getUpdateAccountService() {
		return updateAccountService;
	}

	/**
	 * @param updateAccountService the updateAccountService to set
	 */
	public void setUpdateAccountService(UpdateAccountService updateAccountService) {
		this.updateAccountService = updateAccountService;
	}

	/**
	 * @return the address
	 */
	public List<Address> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(List<Address> address) {
		this.address = address;
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
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @param county the county to set
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	public String updateAccount(){
		
		updateAccountService.updateAcount(firstName, surname, email, addressFirstLine, postcode, county);
		
		return "loginPage"; 
	}
	
	public String getFirstName(){
		return  accountManager.getCustomerByEmail(userCredentials.getEmail()).getFirstName();
		
	}
	
	public String getSurname(){
		return accountManager.getCustomerByEmail(userCredentials.getEmail()).getSurname();
	
	}
	
	public String getEmail(){
		return accountManager.getCustomerByEmail(userCredentials.getEmail()).getEmail(); 
	}
	
	public String getAddressLine1(){
		address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
		if(address.size() > 0)									// TEMP: If an address exists, use the first address of the customer 
			return address.get(0).getLine1();					// 		 (until we can add a page to view multiple addresses).
		else
			return "No address found - Please add your address details."; 
	}
	
	public String getAddressLine2(){
		address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
		if(address.size() > 0)									// TEMP: If an address exists, use the first address of the customer 
			return address.get(0).getLine2();					// 		 (until we can add a page to view multiple addresses).
		else
			return "No address found - Please add your address details."; 
	}
	
	public String getCounty(){
		address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
		if(address.size() > 0)									// TEMP: If an address exists, use the first address of the customer 
			return address.get(0).getCounty();					// 		 (until we can add a page to view multiple addresses).
		else
			return "No address found - Please add your address details."; 
	}
	
	public String getPostcode(){
		address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
		if(address.size() > 0)									// TEMP: If an address exists, use the first address of the customer 
			return address.get(0).getPostcode();				// 		 (until we can add a page to view multiple addresses).
		else
			return "No address found - Please add your address details."; 
	}
	
	

}
