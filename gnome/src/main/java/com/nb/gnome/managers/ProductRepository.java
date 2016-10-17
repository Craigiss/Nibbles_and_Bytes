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

	public Product getProductByName(String name);
	public List<Category> getProductCategories();

	public Product getProductByID(String id);
	public int getStockLevel(String id);
	public List<Product> findAll();
	
	//Update
	public void incrementStock(String id, int quantity);
	public void decrementStock(String id, int quantity);

	List<Product> getProductByCategory(String category); 
	
}
