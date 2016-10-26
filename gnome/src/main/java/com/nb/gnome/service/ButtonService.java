package com.nb.gnome.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.controllers.ProductController;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Supplier;


import gnome.InitialData;

@Stateless
public class ButtonService {
	@Inject private InitialData initialData; 
	@Inject private ProductController prodController;
		
	public String deleteProduct(int id){
		for(Product p : initialData.getProducts())
		{
			if (p.getProductID() == id)
			{
				p.setDeleted(true);
			}
		}
		prodController.reset();
		return "imsProducts";
	}
	
	public String deleteSupplier(int id){
		List<Supplier> suppliers = new ArrayList<Supplier>();
		suppliers = initialData.getSuppliers();
		for(Supplier s : suppliers)
		{
			if (s.getId() == id)
			{
				s.setDeleted(true);
			}
		}
		
		return "imsSupplier";
	}
	
	public String deletePo(int id){	
		return "";
	}

}
