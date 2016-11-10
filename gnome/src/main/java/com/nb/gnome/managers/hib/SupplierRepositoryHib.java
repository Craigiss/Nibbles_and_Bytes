package com.nb.gnome.managers.hib;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.nb.gnome.connection.Connection;
import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.managers.SupplierRepository;

@Stateless
@Alternative
public class SupplierRepositoryHib implements SupplierRepository{

	@Inject 
	private Connection database;
	@Inject 
	private ObjectConverter converter;
	
	//Create
	@Override
	public void persistSupplier(String mCompany, String mName, String mPhone, String mEmail, String mDescription, Address mAddress){
		Supplier s = new Supplier(mCompany, mName, mPhone, mEmail, mDescription, mAddress);
		database.persistData(mAddress, s);
	}
	
	//Read
	@Override
	public Supplier findSupplierById(int id){
		ArrayList<Supplier> supplierList = (ArrayList)converter.convertToSuppliers(database.returnData("Supplier"));
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
		ArrayList<Supplier> supplierList = (ArrayList)converter.convertToSuppliers(database.returnData("Supplier"));
		List<Supplier> suppliers = new ArrayList<Supplier>();
		for (Supplier s: supplierList)
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
		ArrayList<Supplier> supplierList = (ArrayList)converter.convertToSuppliers(database.returnData("Supplier"));
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
		ArrayList<Supplier> supplierList = (ArrayList)converter.convertToSuppliers(database.returnData("Supplier"));
		Supplier sup = new Supplier();
		for (Supplier supplier : supplierList){
			if (supplier.getName().toLowerCase().contains(s.toLowerCase())){
				sup = supplier;
			}
		}
		return sup;
	}

	@Override
	public void deleteSupplier(int id) {
		ArrayList<Supplier> supplierList = (ArrayList)converter.convertToSuppliers(database.returnData("Supplier"));
		for(Supplier s : supplierList)
		{
			if (s.getId() == id)
			{
				s.setDeleted(true);
				database.persistUpdate(s);
			}
		}		
		
	}
	
	//Update
	@Override
	public void persistUpdateSupplier(Supplier sup){
		database.persistUpdate(sup);
	}
}
