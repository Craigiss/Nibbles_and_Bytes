package com.nb.gnome.service;

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

}
