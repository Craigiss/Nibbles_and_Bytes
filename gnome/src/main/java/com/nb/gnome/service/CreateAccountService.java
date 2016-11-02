package com.nb.gnome.service;


import java.util.ArrayList;


import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.Customer;
import com.nb.gnome.managers.CustomerRepository;
import com.nb.gnome.managers.AddressRepository;

import gnome.InitialData;

import com.nb.gnome.entities.Address;

@Stateless
public class CreateAccountService {
	@Inject 
	CustomerRepository customerManager; 
	@Inject 
	InitialData initialData;
	@Inject
	AddressRepository addressManager; 
	
	
	public void newUser(String firstName, String surname, String email, String firstLine,String secondLine, String postcode, String password){
		//Hashing and stuff, split the name to first and last 
		
		Customer c = new Customer();
		Address a = new Address();
		ArrayList<Address> addresses = new ArrayList<Address>();
		a.setId(addressManager.getAddresses().size()+1);
		a.setLine1(firstLine);	
		a.setLine2(secondLine);   // Does the addresses stuff
		a.setPostcode(postcode);
		initialData.addAddress(a);
		addresses.add(a);
		c.setAddresses(addresses);
		
		c.setFirstName(firstName);					// Does the customer credentials.
		c.setSurname(surname);
		c.setEmail(email);
		c.setId(initialData.getCustomerAccounts().size() + 1);
		c.setStatus("active");
		c.setPassword(password);


		customerManager.persistCustomer(c);	
	}
}
