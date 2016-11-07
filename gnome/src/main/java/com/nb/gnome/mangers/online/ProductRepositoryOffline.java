/**
 * 
 */
package com.nb.gnome.mangers.online;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Category;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.ProductCategory;
import com.nb.gnome.managers.ProductRepository;

import gnome.InitialData;


/**
 * Offline Class for Product

 * @author Nibbles and Bytes
 */
@Default
@Stateless
public class ProductRepositoryOffline implements ProductRepository {
	@Inject
	private InitialData initialData;
	
	//Create
	@Override
	public void persistProduct(Product p){
		initialData.addProduct(p);
	}
	
	//Read
	@Override
	public List<Product> getProductByKeyword(String keyword){ 

	List<Product> keywordProduct = new ArrayList<Product>();

	for (Product p: initialData.getProducts()){
	if (p.getProductName().toLowerCase().contains(keyword.toLowerCase()) || p.getDescription().contains(keyword.toLowerCase())){
	keywordProduct.add(p);
	System.out.println(p.getProductName());
	}

	}
	return keywordProduct;
	}
	
	@Override
	public Product getProductByName(String name){
		Product prod = new Product();
		for (Product p: initialData.getProducts()){
			if (p.getProductName() == name)
			{
				prod = p;				
			}
		}
		return prod;
	}
	
	@Override
	public List<Product> getProductByCategory(String category){ // To TEST by cam
		List<Product> prod = new ArrayList<Product>();
		int categoryIdToFind = -1;

		for (Category c : initialData.getCategories()){			// Matches the category name with the id of the category.
			if (c.getName().equals(category)){
				categoryIdToFind = c.getId();
				break;
			}
		}
		if (categoryIdToFind != -1){											// If the category id is valid
				for (ProductCategory pc : initialData.getProductCategories()){	// For each of the productCategories.
					if (pc.getCategoryID() == categoryIdToFind){				// If any of the product match the category we are looking for
						prod.add(getProductByID(pc.getProductID()));			// Add the product
					}
				}
		}
		return prod;
	}
	
	@Override
	public Product getProductByID(int id){
		Product prod = new Product();
		for (Product p: initialData.getProducts()){
			if (p.getProductID() == id)
			{
				prod = p;
			}
		}
		return prod;
	}

	@Override
	public int getStockLevel(int id){
		int stockLevel=-1;
		Product prod = new Product();
		for (Product p: initialData.getProducts()){
			if (p.getProductID() == id)
			{
				prod = p;
			}
		}
		stockLevel=prod.getStockLevel();
		return stockLevel;
	}
	
	//Update
	@Override
	public void incrementStock(int id, int quantity){
		for (Product p: initialData.getProducts()){
			if (p.getProductID() == id)
			{
				p.setStockLevel(p.getStockLevel()+quantity);
			}
		}
		
	}
		
	
	
	@Override
	public void decrementStock(int id, int quantity){
		for (Product p: initialData.getProducts()){
			if (p.getProductID() == id)
			{
				p.setStockLevel(p.getStockLevel()-quantity);
			}
		}
		
	}
	
    @Override
	public List<Product> findAll(){
    	List<Product> p = initialData.getProducts();
    	
    	return p;
    	
    }
/*
	@Override
	public List<Category> getProductCategories(Product prodprod) {
		List<Category> cat = new ArrayList<Category>();
		cat = prodprod.getProductCategories();	
		
		return cat;
	}
*/
	@Override
	public void setQuantity(int id, int quantity) {
		for (Product p: initialData.getProducts()){
			if (p.getProductID() == id)
			{
			 	p.setQuantity(quantity);	
			}
		}
	}

	@Override
	public List<Category> getProductCategories(Product prodprod) {
		// TODO Auto-generated method stub
		return null;
	}


	
}