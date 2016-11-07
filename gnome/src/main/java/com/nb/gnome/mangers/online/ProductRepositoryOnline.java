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
import com.nb.gnome.managers.hib.ObjectConverter;

import connection.Connection;
import gnome.InitialData;

@Default
@Stateless
public class ProductRepositoryOnline implements ProductRepository {
	@Inject
	private Connection connection;
	@Inject 
	private ObjectConverter converter; 
	//Create
	@Override
	public void persistProduct(Product p){
		connection.persistData(p);
	}
	
	//Read
	@Override
	public List<Product> getProductByKeyword(String keyword){ 

	List<Product> keywordProduct = new ArrayList<Product>();

	for (Product p: converter.convertToProducts(connection.returnData("Products"))){
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
		for (Product p: converter.convertToProducts(connection.returnData("Products"))){
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

		for (Category c : converter.ConvertToCategory(connection.returnData("Category"))){			// Matches the category name with the id of the category.
			if (c.getName().equals(category)){
				categoryIdToFind = c.getId();
				break;
			}
		}
		if (categoryIdToFind != -1){											// If the category id is valid
				for (ProductCategory pc : converter.ConvertToProductCategory(connection.returnData("ProductCatagory"))){	// For each of the productCategories.
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
		for (Product p: converter.convertToProducts(connection.returnData("Products"))){
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
		for (Product p:converter.convertToProducts(connection.returnData("Products"))){
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
		for (Product p: converter.convertToProducts(connection.returnData("Products"))){
			if (p.getProductID() == id)
			{
				p.setStockLevel(p.getStockLevel()+quantity);
			}
		}
		
	}
		
	
	
	@Override
	public void decrementStock(int id, int quantity){
		for (Product p: converter.convertToProducts(connection.returnData("Products"))){
			if (p.getProductID() == id)
			{
				p.setStockLevel(p.getStockLevel()-quantity);
			}
		}
		
	}
	
    @Override
	public List<Product> findAll(){
    	List<Product> p = converter.convertToProducts(connection.returnData("Products"));
    	
    	return p;
    	
    }

	@Override
	public void setQuantity(int id, int quantity) {
		for (Product p: converter.convertToProducts(connection.returnData("Products"))){
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
