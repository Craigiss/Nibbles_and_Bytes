/**
 * 
 */
package com.nb.gnome.mangers.offline;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.controllers.GraphController;
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
	@Inject GraphController graph;
	
	//Create
	@Override
	public void persistProduct(String mName, String mDescription, double mPrice, int mStockLevel, int mporousStockLevel){
		Product prodprod = new Product(findAll().size() +1, mName, mDescription, mPrice, mStockLevel, mporousStockLevel);
		if (prodprod.getPorousStockLevel() <= 10){
			graph.setPie3(prodprod.getProductName() + " " + prodprod.getPorousStockLevel() + " products remaining ",prodprod.getPorousStockLevel());
		}
		if (prodprod.getStockLevel() <=10){
			graph.setPie(prodprod.getProductName() + " " + prodprod.getStockLevel() + " products remaining ",prodprod.getStockLevel());
		}		
		initialData.addProduct(prodprod);
	}
	
	//Read
	@Override
	public List<Product> getProductByKeyword(String keyword){ 
		
		List<Product> keywordProduct = new ArrayList<Product>();
		
		for (Product p: initialData.getProducts()){
			if (p.getProductName().toLowerCase().contains(keyword.toLowerCase()) || p.getDescription().toLowerCase().contains(keyword.toLowerCase())){
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
    	List<Product> products = new ArrayList<Product>();
    	for (Product p : initialData.getProducts())
    		if(p.isDeleted() == false)
    		{
    			products.add(p);
    		}
    	return products;
    	
    }

	@Override
	public void persistProduct(String name, String description, double price, int stockLevel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(Product p) {
		
	}

	@Override
	public List<Product> findCritical() {
		List<Product> products = new ArrayList<Product>();
		for (Product p : initialData.getProducts())
		{
			if (p.getStockLevel() <= 10){
				products.add(p);
			}
		}
		return products;
	}
	
	@Override
	public List<Product> findCriticalPourous() {
		List<Product> products = new ArrayList<Product>();
		for (Product p : initialData.getProducts())
		{
			if (p.getPorousStockLevel() <= 10){
				products.add(p);
			}
		}
		return products;
	}
	
	


	
}
