package com.nb.gnome.managers;

import java.util.List;

import com.nb.gnome.entities.Supplier;

/**
 * Interface for SupplierManager classes
 * SupplierManagers will have these methods
 * @author Nibbles and Bytes
 */

public interface SupplierRepository {

	//Create
	public void persistSupplier(Supplier s);
	
	//Read
	public List<Supplier> findSupplierByCompany(String company);
	
	//Read by id
	public Supplier findSupplierById(long id);
	
	
	public Supplier findSupplierByContact(String s);
	
	public List<Supplier> findAll();
	
}
