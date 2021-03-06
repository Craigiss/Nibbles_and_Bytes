package com.nb.gnome.managers;

import com.nb.gnome.entities.Address;

/**
 * Interface for AddressManager classes
 * AddressManagers that implement this interface will interact with the database, either online or offline
 * @author Nibbles and Bytes
 */

public interface AddressRepository {

	//Create
	public void persistAddress(Address a);
	
}
