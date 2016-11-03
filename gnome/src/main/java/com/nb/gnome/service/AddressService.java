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
		return customerRepository.getCustomerById(userId).getAddresses();
	}
	
	
	public void addAddress(String addressFirstLine, String addressSecondLine, String town, String county, String postcode){
		Address address = new Address();
		address.setCounty(county);
		address.setId(customerRepository.getCustomerById(user.getId()).getAddresses().size()+1);
		address.setLine1(addressFirstLine);
		address.setLine2(addressSecondLine);
		address.setPostcode(postcode);
		address.setTown(town);
		customerRepository.getCustomerById(user.getId()).getAddresses().add(address);
	}
	
	public void deleteAddress(int addressId){
		List<Address> customersAddresses = new ArrayList<Address>();
		customersAddresses = getCustomerAddresses();
		for (Address a : customersAddresses){
			if (a.getId() == addressId){
				customersAddresses.remove(a);
				break;
			}

		}
	}
}
