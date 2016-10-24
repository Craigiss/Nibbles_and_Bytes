package com.nb.gnome.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.Product;
import com.nb.gnome.managers.ProductRepository;

import gnome.InitialData;

@Stateless
public class ProductService {
	

	@Inject
	private ProductRepository productManager;
	@Inject
	private InitialData initialData;
	
	/**
	 * Calls Product Manager method, pooling params together to create a new product object
	 */
	public void persistProduct(String mName, String mDescription, double mPrice, int mStockLevel, int mporousStockLevel){
		Product prodprod = new Product(productManager.findAll().size() +1, mName, mDescription, mPrice, mStockLevel, mporousStockLevel);
		productManager.persistProduct(prodprod);
	}
	
	/**
	 *  finds all products and returns these deets as a list
	 * @return
	 * 
	 */
	public List<Product> findAll(){
		List<Product> s = productManager.findAll();
		return s;
		
	}
	
	public Product findProductById(String id){
		
		try{
			int searchId = Integer.parseInt(id);
			return productManager.getProductByID(searchId);
		}
		catch( Exception e){
			return null;
		}	
	}
	
	public List<Product> findProductByKeyword(String keyword){
		try {
			return productManager.getProductByKeyword(keyword);
		}
		catch(Exception e){
			return null;
		}
	}
	
}
