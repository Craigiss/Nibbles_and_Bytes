package com.nb.gnome.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;

import com.mysql.cj.fabric.xmlrpc.base.Array;
import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.Customer;
import com.nb.gnome.managers.AddressRepository;
import com.nb.gnome.managers.CustomerRepository;

import gnome.InitialData;


@Stateful
public class AddressService {
	
	@Inject
	AddressRepository addressRepository;
	@Inject
	CustomerRepository customerRepository;
	@Inject UserCredentials user;
	
	public String addressSummary(int id){
		Address address = addressRepository.getAddressById(id);
		String summary;
		if (address != null){
			summary = address.getLine1() + " - " + address.getTown();
			return summary;
		}
		else{
			summary = "No address found";
			return summary;
		}
		
	}
	
	public List<Address> getCustomerAddresses(){
		int userId = user.getId();
		System.out.println(userId);
		
		return customerRepository.getCustomerById(userId).getAddresses();
	}
	
	
	

}
