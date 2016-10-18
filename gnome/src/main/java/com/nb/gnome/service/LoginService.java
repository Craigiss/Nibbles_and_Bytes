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
		Customer customer = customerManager.getCustomerByEmail(email); 
		if (customer == null){
			return false;
		}
		if(customer.getPassword().matches(pass)){
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
