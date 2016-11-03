package com.nb.gnome.mangers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

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
		List<Supplier> s = initialData.getSuppliers();
		return s;
		
	}

	@Override
	public List<Supplier> findSupplierByCompany(String company) {
		List<Supplier> sup = new ArrayList<Supplier>();
		for (Supplier s : initialData.getSuppliers()){
			if (s.getCompany().contains(company))
			{
				sup.add(s);
			}
		}
		return sup;
		
	}
	
}
