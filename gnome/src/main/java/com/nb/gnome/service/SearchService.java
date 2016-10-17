package com.nb.gnome.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.Product;
import com.nb.gnome.managers.ProductRepository;
import com.nb.gnome.managers.PurchaseOrderRepository;
import com.nb.gnome.managers.SupplierRepository;

@Stateless
public class SearchService {
	@Inject private ProductRepository prodRepo;
	@Inject private SupplierRepository suppRepo;
	@Inject private PurchaseOrderRepository poRepo;
	
	
	public Product findProductById(String id){
		
		try{
			int searchId = Integer.parseInt(id);
			return prodRepo.getProductByID(searchId);
		}
		catch( Exception e){
			return null;
		}	
	}
	
	public Product findProductByKeyword(String keyword){
		return null;
	}
	
	
	
	
	
	
}
