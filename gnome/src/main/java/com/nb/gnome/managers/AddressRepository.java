package com.nb.gnome.managers;

import java.util.List;

import com.nb.gnome.entities.Address;

/**
 * Interface for AddressManager classes
 * AddressManagers that implement this interface will interact with the database, either online or offline
 * @author Nibbles and Bytes
 */

public interface AddressRepository {

	//Create
	public void persistAddress(Address a);

	public Address getAddressById(int id);
	
	public int getAddressIdByFirstLineAndPostcode(String firstLine, String postcode);
	
	public List<Address> getAddresses();
	
}
