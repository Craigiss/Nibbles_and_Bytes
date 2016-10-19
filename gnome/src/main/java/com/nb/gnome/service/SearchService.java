package com.nb.gnome.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.Product;
import com.nb.gnome.managers.ProductRepository;
import com.nb.gnome.managers.PurchaseOrderRepository;
import com.nb.gnome.managers.SupplierRepository;

@Stateless
public class SearchService {
	@Inject private ProductRepository prodRepo;
//	@Inject private SupplierRepository suppRepo;
//	@Inject private PurchaseOrderRepository poRepo;
	
	public ProductRepository getProductRepository(){
		return prodRepo;
	}
	
	public Product findProductById(String id){
		
		try{
			int searchId = Integer.parseInt(id);
			return prodRepo.getProductByID(searchId);
		}
		catch( Exception e){
			return null;
		}	
	}
	
	public List<Product> findProductByKeyword(String keyword){
		try {
			return prodRepo.getProductByKeyword(keyword);
		}
		catch(Exception e){
			return null;
		}
	}
	
	
	
	
	
	
}
