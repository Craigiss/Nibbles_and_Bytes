package com.nb.gnome.managers;

import java.util.List;

import com.nb.gnome.entities.ISAccount;

/**
 * Interface for InventoryStaffAccount Manager classes
 * InventoryStaffAccount Managers will have these methods
 * @author Nibbles and Bytes
 */

public interface ISAccountRepository {
	
	//Create
	public void persistISAccount(ISAccount isa);
	
	//Read
	public ISAccount findISAccountByEmail(String email);
	
	//Update
	public void updateISAccountName(ISAccount isa);
	public void updateISAccountEmail(ISAccount isa);
	public void updateISAccountPassword(ISAccount isa);
}
