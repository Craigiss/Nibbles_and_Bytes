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
	public void persistProduct(String mName, String mDescription, double mPrice, int mStockLevel, int mporousStockLevel);
	
	//Read
	public List<Product> getProductByKeyword(String keyword);

	public Product getProductByName(String name);

	public Product getProductByID(int id);
	public int getStockLevel(int id);
	public List<Product> findAll();
	
	//Update
	public void incrementStock(int id, int quantity);
	public void decrementStock(int id, int quantity);

	public void persistProduct(String name, String description, double price, int stockLevel); 
	
	public void deleteProduct(Product p);

	public List<Product> findCritical();

	public List<Product> findCriticalPourous();
	
}
