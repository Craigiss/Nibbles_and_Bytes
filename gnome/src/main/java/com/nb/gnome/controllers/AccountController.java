package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.RequestScoped;
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
