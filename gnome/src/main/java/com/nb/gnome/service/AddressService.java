package com.nb.gnome.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.Address;
import com.nb.gnome.managers.AddressRepository;

@Stateless
public class AddressService {

	@Inject
	private AddressRepository addressRepository;
	
	public void persistAddress(Address a){
		addressRepository.persistAddress(a);
	}
}
