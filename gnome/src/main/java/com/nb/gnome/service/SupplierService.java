package com.nb.gnome.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.Supplier;
import com.nb.gnome.managers.SupplierRepository;

@Stateless
public class SupplierService {
	

	@Inject
	private SupplierRepository supplierManager;
	
	/**
	 *  'persists' (adds) a new supplier to the system
	 * @param supsup
	 */
	public void persistSupplier(Supplier supsup){
		supplierManager.persistSupplier(supsup);
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
	public Supplier findSupplierById(long id){
		return supplierManager.findSupplierById(id);
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
