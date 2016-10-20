package com.nb.gnome.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.Customer;
import com.nb.gnome.managers.CustomerRepository;

import gnome.InitialData;



@Stateless
public class UpdateAccountService {
    @Inject 
    CustomerRepository  customerRepository; 
	@Inject 
	InitialData initialData;  
	
	public void updateAcount(String firstName, String surname, String email, String firstLine, String postcode, String county){
		
		Customer c = customerRepository.getCustomerByEmail(email);
		
		Address a = new Address();
		ArrayList<Address> addresses = new ArrayList<Address>();
		
		a.setLine1(firstLine);						// Does the addresses stuff
		a.setPostcode(postcode);
		a.setCounty(county);
		addresses.add(a);
		
		customerRepository.changeEmailAddress(email, c.getId());
		customerRepository.changeFirstName(firstName, c.getId());
		customerRepository.changeSurname(surname, c.getId());
		customerRepository.changecustomerAddress(addresses, c.getId());
	}
}