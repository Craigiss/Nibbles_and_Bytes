package com.nb.gnome.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.managers.SupplierRepository;

import gnome.InitialData;

@Stateless
@Default
public class SupplierRepositoryOffline implements SupplierRepository{

	@Inject
	private InitialData initialData;

	//Create
	@Override
	public void persistSupplier(Supplier s){
		initialData.addSupplier(s);
	}
	
	@Override
	public Supplier findSupplierById(long id){
		Supplier sup = new Supplier();
		for (Supplier s : initialData.getSuppliers()){
			if (s.getId() == id)
			{
				sup = s;
			}
		}
		return sup;
	}
	
	@Override
	public List<Supplier> findAll(){
		List<Supplier> suppliers = new ArrayList<Supplier>();
		for (Supplier s: initialData.getSuppliers())
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
		for (Supplier s : initialData.getSuppliers()){
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
		for (Supplier supplier : initialData.getSuppliers()){
			if (supplier.getName().toLowerCase().contains(s.toLowerCase())){
				sup = supplier;
			}
		}
		return sup;
	}

	@Override
	public List<Product> getProducts(Supplier supplier) {
		return supplier.getProducts();
	}
	
}
