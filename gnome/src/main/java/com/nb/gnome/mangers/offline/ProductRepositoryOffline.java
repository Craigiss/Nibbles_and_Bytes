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
		List<Product> p = initialData.getProducts();
		
		
		return(p);
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
	public List<Category> getProductCategories(){
		ArrayList<Category> c = new ArrayList<Category>();
		
		return(c);
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
		int stockLevel = 0;
		
		return(stockLevel);
	}
	
	//Update
	@Override
	public void incrementStock(int id, int quantity){
		
	}
	
	@Override
	public void decrementStock(int id, int quantity){
		
	}
	
    @Override
	public List<Product> findAll(){
    	List<Product> p = initialData.getProducts();
    	return p;
    	
    }
	
	

	
}
