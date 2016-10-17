package com.nb.gnome.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.Supplier;
import com.nb.gnome.managers.SupplierRepository;

@Stateless
public class SupplierService {
	

	@Inject
	private SupplierRepository supplierManager;
	
	public void persistSupplier(Supplier supsup){
		supplierManager.persistSupplier(supsup);
	}

}
