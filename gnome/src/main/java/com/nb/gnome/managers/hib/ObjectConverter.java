package com.nb.gnome.managers.hib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

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
	
}
