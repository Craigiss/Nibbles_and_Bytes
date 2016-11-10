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
	public void persistISAccountAdmin(ISAccount isa);
	
	
	//Read
	public ISAccount findISAccountByEmail(String email);
	public String findSaltByEmail(String email);
	
	//Update
	public void updateISAccountName(ISAccount isa);
	public void updateISAccountEmail(ISAccount isa);
	public void updateISAccountPassword(ISAccount isa);

	public List<ISAccount> findAll();
	
	//Password Security
	public String hashSha256(String toHash) throws Exception;
	public String addSeasoning(String password, String salt);
	public String seasonAndCook(String email, String password) throws Exception;
	String seasonAndCook(String email, String npassword, String nsalt) throws Exception;
	
}
