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

	@Inject
	AddressService addressService;

	private List<Address> address; // Customer's addresses.

	private String email;
	private String firstName;
	private String surname;
	private String addressFirstLine;
	private String addressSecondLine;
	private String town;
	private String county;
	private String postcode;

	private int selectedAddress; // The ID of the address selected by the
									// dropdown box.

	public void updateAddresses(ValueChangeEvent e) { // Updates address by drop
														// down box selected
														// address.
		address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses(); // Gets
																								// the
																								// customer's
																								// addresses.
		int addressIdToFind = 0;

		for (Address a : address) {
			if (a.getId() == selectedAddress)
				addressIdToFind = a.getId();
		}
		for (Address a : address) {
			if (a.getId() == addressIdToFind) { // if the address id matches the
												// id of the new address we are
												// looking for...
				setTown(a.getTown());
				setAddressFirstLine(a.getLine1());
				setAddressSecondLine(a.getLine2());
				setPostcode(a.getPostcode());
				setCounty(a.getCounty());
				break;
			}

		}

	}

	public String getAddressSummary() {
		return (addressService.addressSummary(selectedAddress));
	}

	public String goHome() {
		return "homePage";

	}

	/**
	 * @return the selectedAddress
	 */
	public int getSelectedAddress() {
		return selectedAddress;
	}

	/**
	 * @param selectedAddress
	 *            the selectedAddress to set
	 */
	public void setSelectedAddress(int selectedAddress) {
		this.selectedAddress = selectedAddress;
	}

	/**
	 * @return the address
	 */
	public List<Address> getAddress() {
		// return addressService.getCustomerAddresses();
		try{
			
		
		address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
		return address;
		}
		catch(NullPointerException e){
			return null;
		}
	}

	/**
	 * @return the userCredentials
	 */
	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	/**
	 * @param userCredentials
	 *            the userCredentials to set
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
	 * @param updateAccountService
	 *            the updateAccountService to set
	 */
	public void setUpdateAccountService(UpdateAccountService updateAccountService) {
		this.updateAccountService = updateAccountService;
	}


	public void updateAccount(){
		updateAccountService.updateAccount(firstName, surname, email);
		updateAccountService.updateAddress(userCredentials.getId(), selectedAddress, addressFirstLine,
				addressSecondLine, town, county, postcode);
	}

	public void testingMethod() {
		System.out.println("reached");
	}

	/**
	 * @param accountManager
	 *            the accountManager to set
	 */
	public void setAccountManager(CustomerRepository accountManager) {
		this.accountManager = accountManager;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(List<Address> address) {
		this.address = address;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @param addressFirstLine
	 *            the addressFirstLine to set
	 */
	public void setAddressFirstLine(String addressFirstLine) {
		this.addressFirstLine = addressFirstLine;
	}

	/**
	 * @param postcode
	 *            the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @param county
	 *            the county to set
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * @param addressSecondLine
	 *            the addressSecondLine to set
	 */
	public void setAddressSecondLine(String addressSecondLine) {
		this.addressSecondLine = addressSecondLine;
	}

	public String getFirstName() {
		try {
			return accountManager.getCustomerByEmail(userCredentials.getEmail()).getFirstName();
		} catch (NullPointerException e) {
			return "loginPage";

		}

	}

	public String getSurname() {

		try {
			return accountManager.getCustomerByEmail(userCredentials.getEmail()).getSurname();
		} catch (NullPointerException e) {
			return "loginPage";

		}
	}

	public String getEmail() {

		try {
			return accountManager.getCustomerByEmail(userCredentials.getEmail()).getEmail();
		} catch (NullPointerException e) {
			return "loginPage";
		}
	}

	public String getAddressFirstLine() {

		try {
			address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
			if (address.size() > 0) {

				for (Address a : address) {
					if (a.getId() == selectedAddress)
						return a.getLine1();
				}
				return address.get(0).getLine1();
			}
			else
				return "No address found - Please add your address details.";
		} catch (NullPointerException e) {
			return "loginPage";
		}
	}

	public String getAddressSecondLine() {
		
		try {
			address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
			if (address.size() > 0) {

				for (Address a : address) {
					if (a.getId() == selectedAddress)
						return a.getLine2();
				}
				return address.get(0).getLine2();
			}
			// (until we can add a page to view multiple addresses).
			else
				return "No address found - Please add your address details.";
		} catch (NullPointerException e) {
			return "loginPage";
		}
	}

	public String getCounty() {
		
		try {
			address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
			if (address.size() > 0) {

				for (Address a : address) {
					if (a.getId() == selectedAddress)
						return a.getCounty();
				}
				return address.get(0).getCounty();
			}
			// (until we can add a page to view multiple addresses).
			else
				return "No address found - Please add your address details.";
		} catch (NullPointerException e) {
			return "loginPage";

		}
	}

	public String getPostcode() {
		
		try {
			address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
			if (address.size() > 0) {

				for (Address a : address) {
					if (a.getId() == selectedAddress)
						return a.getPostcode();
				}
				return address.get(0).getPostcode();
			}
			// (until we can add a page to view multiple addresses).
			else
				return "No address found - Please add your address details.";
		} catch (NullPointerException e) {
			return "loginPage";
		}
	}

	/**
	 * @return the town
	 */
	public String getTown() {
		
		try {
			address = accountManager.getCustomerByEmail(userCredentials.getEmail()).getAddresses();
			if (address.size() > 0) {

				for (Address a : address) {
					if (a.getId() == selectedAddress)
						return a.getTown();
				}
				return address.get(0).getTown();
			}
			// (until we can add a page to view multiple addresses).
			else
				return "No address found - Please add your address details.";
		} catch (NullPointerException e) {
			return "loginPage";

		}
	}
	
	public String addAddress(){
		
		addressService.addAddress(addressFirstLine, addressSecondLine, town, county, postcode);
		return "account";
		
	}
	
	public String deleteAddress(){
		
		addressService.deleteAddress(selectedAddress);
		return "account";
	}

	/**
	 * @param town
	 *            the town to set
	 */
	public void setTown(String town) {
		this.town = town;
	}
}
