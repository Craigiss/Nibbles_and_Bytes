package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Address;
import com.nb.gnome.managers.AddressRepository;
import com.nb.gnome.managers.CustomerRepository;
import com.nb.gnome.service.AddressService;
import com.nb.gnome.service.LoginService;
import com.nb.gnome.service.UpdateAccountService;
import com.nb.gnome.service.UserCredentials;

@Named("Account")
@SessionScoped
public class AccountController implements Serializable {
	@Inject
	UserCredentials userCredentials;
	
	@Inject 
	UpdateAccountService updateAccountService;
	@Inject
	CustomerRepository accountManager;
	@Inject
	AddressRepository addressManager;
	
	AddressService addressService;
	

	private List<Address> address;


	private String email; 
    private String firstName; 
    private String surname; 
    private String addressFirstLine;
    private String addressSecondLine;
    private String town;
    private String county; 
    private String postcode;

    private int selectedAddress = 1 ;								// The ID of the address selected by the dropdown box.
    
    public void updateAddresses(ValueChangeEvent e){
    	
    	address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
    	for (Address a: address){
    		if (a.getId()==addressManager.getAddressById(address.get(selectedAddress).getId()).getId()){ // Change here
    			setTown(a.getTown());
    			setAddressFirstLine(a.getLine1());
    	    	setAddressSecondLine(a.getLine2());
    	    	setPostcode(a.getPostcode());
    	    	setCounty(a.getPostcode());
    		}
    	}
    
   
    }
    
    public String getAddressSummary(){
    	return(addressService.addressSummary(selectedAddress));
    }

    public String goHome(){
		return "homePage";
    	
    }
    
    /**
	 * @return the selectedAddress
	 */
	public int getSelectedAddress() {
		return selectedAddress;
	}

	/**
	 * @param selectedAddress the selectedAddress to set
	 */
	public void setSelectedAddress(int selectedAddress) {
		this.selectedAddress = selectedAddress;
	}

	/**
	 * @return the address
	 */
	public List<Address> getAddress() {
		//return addressService.getCustomerAddresses();
		address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
		return address;
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


	public void updateAccount(){
		System.out.println("reached");
		updateAccountService.updateAccount(firstName, surname, email, addressFirstLine, postcode, county,addressSecondLine, town);
	}

	public void testingMethod()
	{
		System.out.println("reached");
	}

	
	
	
	/**
	 * @param accountManager the accountManager to set
	 */
	public void setAccountManager(CustomerRepository accountManager) {
		this.accountManager = accountManager;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(List<Address> address) {
		this.address = address;
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
	 * @param addressFirstLine the addressFirstLine to set
	 */
	public void setAddressFirstLine(String addressFirstLine) {
		this.addressFirstLine = addressFirstLine;
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

	/**
	 * @param addressSecondLine the addressSecondLine to set
	 */
	public void setAddressSecondLine(String addressSecondLine) {
		this.addressSecondLine = addressSecondLine;
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
	
	public String getAddressFirstLine(){
		address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
		if(address.size() > 0)									// TEMP: If an address exists, use the first address of the customer 
			return address.get(selectedAddress).getLine1();					// 		 (until we can add a page to view multiple addresses).
		else
			return "No address found - Please add your address details."; 
	}
	
	public String getAddressSecondLine(){
		address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
		if(address.size() > 0)									// TEMP: If an address exists, use the first address of the customer 
			return address.get(selectedAddress).getLine2();					// 		 (until we can add a page to view multiple addresses).
		else
			return "No address found - Please add your address details."; 
	}
	

	public String getCounty(){
		address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
		if(address.size() > 0)									// TEMP: If an address exists, use the first address of the customer 
			return address.get(selectedAddress).getCounty();					// 		 (until we can add a page to view multiple addresses).
		else
			return "No address found - Please add your address details."; 
	}
	
	public String getPostcode(){
		address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
		if(address.size() > 0)									// TEMP: If an address exists, use the first address of the customer 
			return address.get(selectedAddress).getPostcode();				// 		 (until we can add a page to view multiple addresses).
		else
			return "No address found - Please add your address details."; 
	}
	
	/**
	 * @return the town
	 */
	public String getTown() {
		address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
		if(address.size() > 0)									// TEMP: If an address exists, use the first address of the customer 
			return address.get(selectedAddress).getTown();					// 		 (until we can add a page to view multiple addresses).
		else
			return "No address found - Please add your address details."; 
	}

	/**
	 * @param town the town to set
	 */
	public void setTown(String town) {
		this.town = town;
	}
}

