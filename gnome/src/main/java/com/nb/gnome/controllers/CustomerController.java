package com.nb.gnome.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Customer;
import com.nb.gnome.managers.CustomerRepository;

@Named("customer")
@SessionScoped
public class CustomerController implements Serializable {
	@Inject
	private CustomerRepository customerRepository; 
	private Customer customer; 
	

	public Customer view(long id){
		customer = customerRepository.getCustomerById(id);
		return customer;
	}
	
	public Customer getCustomer(){
		return customer;
		
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
