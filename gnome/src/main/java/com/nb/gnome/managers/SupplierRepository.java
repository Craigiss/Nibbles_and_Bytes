package com.nb.gnome.managers;

import java.util.List;

import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Supplier;

/**
 * Interface for SupplierManager classes
 * SupplierManagers will have these methods
 * @author Nibbles and Bytes
 */

public interface SupplierRepository {

	//Create
	public void persistSupplier(String mCompany, String mName, String mPhone, String mEmail, String mDescription, Address mAddress);
	
	//Read
	public List<Supplier> findSupplierByCompany(String company);
	
	//Read by id
	public Supplier findSupplierById(int id);
	
	public Supplier findSupplierByContact(String s);
	
	public List<Supplier> findAll();
	
	//Update
	public void persistUpdateSupplier(Supplier sup);
	
	//Delete
	public void deleteSupplier(int id);

}
