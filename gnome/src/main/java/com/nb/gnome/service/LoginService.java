package com.nb.gnome.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.Customer;
import com.nb.gnome.managers.CustomerRepository;

@Stateless
public class LoginService {
	@Inject
	CustomerRepository customerManager;
	
	public boolean validateDetails(String email, String pass){
		 
		if (customerManager.getCustomerByEmail(email) == null){
			return false;
		}
		if(customerManager.getCustomerByEmail(email).getPassword().matches(pass)){
			return true; 
		}
		
		
		return false;
		
	}
	
	public String getName(String email){
		
		Customer customer = customerManager.getCustomerByEmail(email);
		String name = customer.getFirstName();
		return name;
	}
}
