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

//	//Read
//	public Supplier findSupplierByCompany(String s) {
//		Supplier newOne = new Supplier();
//		for(Supplier company : initialData.getSuppliers()){
//			if (company.getCompany() == s){
//				newOne = company;
//				break;
//			}
//		}
//		return newOne;
//	}
	
	@Override
	public Supplier findSupplierById(long id){
		return new Supplier();
	}
	
	@Override
	public List<Supplier> findAll(){
		return new ArrayList<Supplier>();
		
	}

	@Override
	public Supplier findSupplier(Supplier s) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
