package com.nb.gnome.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.Customer;
import com.nb.gnome.managers.AddressRepository;
import com.nb.gnome.managers.CustomerRepository;

import gnome.InitialData;

@Stateless

public class UpdateAccountService {
    @Inject 
    CustomerRepository  customerRepository; 
	@Inject 
	InitialData initialData;  
	@Inject 
	UserCredentials userCredentials;
	@Inject
	AddressRepository addressRepository;
	@Inject
	AddressService addressService;
	
	public void updateAccount(String firstName, String surname, String email){
		
		Customer c = customerRepository.getCustomerByEmail(userCredentials.getEmail());
		userCredentials.setEmail(email);
		userCredentials.setUser(firstName);

		customerRepository.changeEmailAddress(email, c.getId());
		customerRepository.changeFirstName(firstName, c.getId());
		customerRepository.changeSurname(surname, c.getId());

	}
	
	public void updateAddress(int customerId, int addressId, String firstLine, String secondLine, String town, String county, String postcode){
		List<Address> customersAddresses = new ArrayList<Address>();
		customersAddresses = addressService.getCustomerAddresses();
		for (Address a : customersAddresses){
			if (a.getId() == addressId){
				customersAddresses.remove(a);			// Remove the address that we are changing.
				Address updatedAddress = new Address();	// Edit the new address.
				updatedAddress.setId(addressId);
				updatedAddress.setLine1(firstLine);
				updatedAddress.setLine2(secondLine);
				updatedAddress.setTown(town);
				updatedAddress.setPostcode(postcode);
				updatedAddress.setCounty(county);
				customersAddresses.add(updatedAddress); // Add the updated address to the collection.
				break;
			}
		}
		
		customerRepository.changecustomerAddress(customersAddresses, customerId);
	}
}
