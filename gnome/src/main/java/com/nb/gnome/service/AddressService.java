package com.nb.gnome.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;

import com.nb.gnome.entities.Address;
import com.nb.gnome.managers.AddressRepository;
import com.nb.gnome.managers.CustomerRepository;


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
	
	public List<Address> getActiveCustomerAddresses(){
		int userId = user.getId();
		List<Address> activeAddresses = new ArrayList<Address>();
		for(Address a : customerRepository.getCustomerById(userId).getAddresses()){
			if (a.isActive() == true){
				activeAddresses.add(a);
			}
		}
		return activeAddresses;
	}
	
	
	public void addAddress(String addressFirstLine, String addressSecondLine, String town, String county, String postcode){
		
		Address address = new Address();
		address.setCounty(county);
		address.setLine1(addressFirstLine);
		address.setLine2(addressSecondLine);
		address.setPostcode(postcode);
		address.setTown(town);
		address.setCustomer(customerRepository.getCustomerById(user.getId()));
		addressRepository.persistAddress(address);
	}
	
	public void deleteAddress(int addressId){
		List<Address> customersAddresses = new ArrayList<Address>();
		customersAddresses = getActiveCustomerAddresses();
		int customerID = customersAddresses.get(0).getCustomer().getId();
		for (Address a : customersAddresses){
			if (a.getId() == addressId){
				Address addressMarkedForDelete = a;
				addressMarkedForDelete.setActive(false);
				customersAddresses.remove(a);
				customersAddresses.add(addressMarkedForDelete);
				break;
			}
		}
		customerRepository.changecustomerAddress(customersAddresses, customerID);
	}
}
