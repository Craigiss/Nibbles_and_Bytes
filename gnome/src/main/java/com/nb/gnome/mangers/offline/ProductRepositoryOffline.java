/**
 * 
 */
package com.nb.gnome.mangers.offline;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Category;
import com.nb.gnome.entities.Customer;
import com.nb.gnome.entities.Product;
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
			if (p.getProductName().contains(keyword) || p.getDescription().contains(keyword) || p.getProductName().toLowerCase().contains(keyword)|| p.getDescription().toLowerCase().contains(keyword)){
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
	public List<Product> getProductByCategory(String category){ // To sort out
		List<Product> prod = new ArrayList<Product>();
		for (Product p: initialData.getProducts()){
			List<Category> categories = new ArrayList<Category>();
			categories = p.getCategories();			
			for (Category c : categories){
				if (c.getName() == category){
					prod.add(p);
					break;
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

	@Override
	public List<Category> getProductCategories(Product prodprod) {
		List<Category> cat = new ArrayList<Category>();
		cat = prodprod.getCategories();	
		
		return cat;
	}

	@Override
	public void persistProduct(String name, String description, double price, int stockLevel) {
		// TODO Auto-generated method stub
		
	}


	
}
