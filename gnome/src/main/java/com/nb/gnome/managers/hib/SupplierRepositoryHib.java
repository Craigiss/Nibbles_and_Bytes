package com.nb.gnome.managers.hib;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.nb.gnome.connection.Connection;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.managers.SupplierRepository;

@Stateless
@Alternative
public class SupplierRepositoryHib implements SupplierRepository{

	@Inject 
	private Connection database;
	@Inject 
	private ObjectConverter converter;
	
	
	private ArrayList<Supplier> supplierList;

	//Create
	@Override
	public void persistSupplier(Supplier s){
		database.persistData(s);
	}
	
	@Override
	public Supplier findSupplierById(long id){
		Supplier sup = new Supplier();
		for (Supplier s : supplierList ){
			if (s.getId() == id)
			{
				sup = s;
			}
		}
		return sup;
	}
	
	@Override
	public List<Supplier> findAll(){
		ArrayList<Supplier> test = (ArrayList)converter.convertToSuppliers(database.returnData("Supplier"));
		List<Supplier> suppliers = new ArrayList<Supplier>();
		for (Supplier s: test)
		{
			if (s.isDeleted() ==false)
			{
				suppliers.add(s);
			}
		}
		return suppliers;
		
	}

	@Override
	public List<Supplier> findSupplierByCompany(String company) {
		List<Supplier> sup = new ArrayList<Supplier>();
		for (Supplier s : supplierList){
			if (s.getCompany().toLowerCase().contains(company.toLowerCase()))
			{
				sup.add(s);
			}
					}
		return sup;
	}

	@Override
	public Supplier findSupplierByContact(String s) {
		Supplier sup = new Supplier();
		for (Supplier supplier : supplierList){
			if (supplier.getName().toLowerCase().contains(s.toLowerCase())){
				sup = supplier;
			}
		}
		return sup;
	}
	
}
