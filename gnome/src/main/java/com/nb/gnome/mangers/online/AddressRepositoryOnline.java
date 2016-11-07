package com.nb.gnome.mangers.online;


import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Address;
import com.nb.gnome.managers.AddressRepository;
import com.nb.gnome.managers.hib.ObjectConverter;

import connection.*;

import gnome.InitialData;
@Default
@Stateless
public class AddressRepositoryOnline implements AddressRepository{
	
	@Inject
	private Connection connection;

	@Inject
	private ObjectConverter converter;
	//Create
	@Override
	public void persistAddress(Address a){
		connection.persistData(a);
	}
	
	@Override
	public int getAddressIdByFirstLineAndPostcode(String firstLine, String postcode){
		int id = -1;
		for (Address a : converter.convertToAddress(connection.returnData("Address"))){
			if (a.getLine1() == firstLine && a.getPostcode() == postcode){
				id = a.getId();
				break;
			}
		}
		return(id);
	}
	
	@Override
	public Address getAddressById(int id){
		for(Address a : initialData.getAddresses()){
			if (a.getId() == id)
				return(a);
		}
		return null;

	}
	
	public List<Address> getAddresses(){
		return initialData.getAddresses();
	}
	
	//Read method called from Customer
	//Update or delete methods are not necessary
}
