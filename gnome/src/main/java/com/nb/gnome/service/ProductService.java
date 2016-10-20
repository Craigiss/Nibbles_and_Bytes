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
	 * Calls Supplier Manager method, pooling params together to create a new Supplier object
	 */
	public void persistProduct(String mName, String mDescription, double mPrice, int mStockLevel){
		Product prodprod = new Product(initialData.getProducts().size() +1, mName, mDescription, mPrice, mStockLevel);
		productManager.persistProduct(prodprod);
	}
	
	/**
	 *  finds all suppliers and returns these deets as a list
	 * @return
	 */
	public List<Product> findAll(){
		List<Product> s = productManager.findAll();
		return s;
		
	}
	
	/**
	 *  finds a particular supplier from a given id that matches said id
	 * @param id
	 * @return
	 */
	public Product findProductById(long id){
		return productManager.findProductById(id);
	}

	/**
	 *  finds a supplier by a given company name
	 * @param company
	 * @return
	 */
	public List<Product> findSupplierByCompany(String company) {
		return productManager.findProductByCompany(company);
	}
	
}
