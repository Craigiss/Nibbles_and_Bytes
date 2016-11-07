package com.nb.gnome.mangers.online;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Supplier;
import com.nb.gnome.managers.SupplierRepository;
import com.nb.gnome.managers.hib.ObjectConverter;

import connection.Connection;
import gnome.InitialData;

@Stateless
@Default
public class SupplierRepositoryOffline implements SupplierRepository{

	@Inject
	private Connection connection;

	@Inject
	private ObjectConverter converter;

	//Create
	@Override
	public void persistSupplier(Supplier s){
		connection.persistData(s);
	}

	@Override
	public Supplier findSupplierById(long id){
		Supplier sup = new Supplier();
		for (Supplier s : converter.convertToSuppliers(connection.returnData("Suppliers"))){
			if (s.getId() == id)
			{
				sup = s;
			}
		}
		return sup;
	}
	
	@Override
	public List<Supplier> findAll(){
		List<Supplier> s = converter.convertToSuppliers(connection.returnData("Suppliers"));
		return s;
		
	}

	@Override
	public List<Supplier> findSupplierByCompany(String company) {
		List<Supplier> sup = new ArrayList<Supplier>();
		for (Supplier s : converter.convertToSuppliers(connection.returnData("Suppliers"))){
			if (s.getCompany().contains(company))
			{
				sup.add(s);
			}
		}
		return sup;
		
	}
	
}
