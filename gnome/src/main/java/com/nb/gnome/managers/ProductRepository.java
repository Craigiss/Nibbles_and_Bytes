package com.nb.gnome.managers;

import java.util.List;
import com.nb.gnome.entities.*;
/**
 * Interface for Product classes
 * ProductManager will have these methods
 * @author Nibbles and Bytes
 */

public interface ProductRepository {
	//Create
	public void persistProduct(Product p);
	
	//Read
	public List<Product> getProductByKeyword(String keyword);
	public List<Product> getProductByName(String name);
	public List<Category> getProductCategories();
	public Product getProductByID(int id);
	public int getStockLevel(int id);
	public List<Product> findAll();
	
	//Update
	public void incrementStock(int id, int quantity);
	public void decrementStock(int id, int quantity); 
	
}
