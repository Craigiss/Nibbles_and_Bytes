package com.nb.gnome.managers.hib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.nb.gnome.entities.ISAccount;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Supplier;

@Stateless
public class ObjectConverter implements Serializable {

	public List<Supplier> convertToSuppliers(List<Object> objectList){
		List<Supplier> supplierList = new ArrayList<Supplier>();
		
		for (Object o : objectList){
			supplierList.add((Supplier)o);
		}
		return supplierList;
	}
	
	public List<Product> convertToProducts(List<Object> objectList){
		List<Product> productList = new ArrayList<Product>();
		
		for (Object o : objectList){
			productList.add((Product)o);
		}
		return productList;
	}
	
	public List<ISAccount> convertToAccount(List<Object> objectList){
		List<ISAccount> accountList = new ArrayList<ISAccount>();
		
		for (Object o : objectList){
			accountList.add((ISAccount)o);
		}
		return accountList;
	}
	
	
	
}
