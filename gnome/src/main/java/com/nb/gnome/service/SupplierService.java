package com.nb.gnome.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.managers.SupplierRepository;

import gnome.InitialData;

@Stateless
public class SupplierService {
	

	@Inject
	private SupplierRepository supplierManager;
	
	/**
	 * Calls Supplier Manager method, pooling params together to create a new Supplier object
	 */
	public void persistSupplier(String mCompany, String mName, String mPhone, String mEmail, String mDescription, Address mAddress){
		supplierManager.persistSupplier(mCompany, mName, mPhone, mEmail, mDescription, mAddress);
	}
	
	/**
	 *  finds all suppliers and returns these deets as a list
	 * @return
	 */
	public List<Supplier> findAll(){
		List<Supplier> s = supplierManager.findAll();
		return s;
		
	}
	
	/**
	 *  finds a particular supplier from a given id that matches said id
	 * @param id
	 * @return
	 */
	public Supplier findSupplierById(String id){
		try{
			long searchId = Long.parseLong(id);
			return supplierManager.findSupplierById(searchId);
		}
		catch( Exception e){
			return null;
		}	
	}
	
	public Supplier findSupplierByContact(String name){
		try {
			Supplier s = supplierManager.findSupplierByContact(name);
			if (s.getName().equals(null))
			{
				System.out.println("error");
				return null;
			}
			return s;
		}
		catch (Exception e) {
			return null;
		}		
	}

	/**
	 *  finds a supplier by a given company name
	 * @param company
	 * @return
	 */
	public List<Supplier> findSupplierByCompany(String company) {
		return supplierManager.findSupplierByCompany(company);

	}	

}


