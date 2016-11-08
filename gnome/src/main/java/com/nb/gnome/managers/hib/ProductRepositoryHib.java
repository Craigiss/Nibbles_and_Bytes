/**
 * 
 */
package com.nb.gnome.managers.hib;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.nb.gnome.connection.Connection;
import com.nb.gnome.controllers.GraphController;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.managers.ProductRepository;

import gnome.InitialData;


/**
 *  * @author Nibbles and Bytes
 */
@Stateless
@Alternative
public class ProductRepositoryHib implements ProductRepository {
	
	@Inject
	private Connection database;
	
	@Inject
	private ObjectConverter converter;
	
	@Inject 
	private GraphController graph;
	
	//Create
	@Override
	public void persistProduct(String mName, String mDescription, double mPrice, int mStockLevel, int mporousStockLevel, Supplier supplier){
		System.out.println(supplier.getClass() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Product prodprod = new Product(mName, mDescription, mPrice, mStockLevel, mporousStockLevel, supplier);
		if (prodprod.getPorousStockLevel() <= 10){
			graph.setPie3(prodprod.getProductName() + " " + prodprod.getPorousStockLevel() + " products remaining ",prodprod.getPorousStockLevel());
		}
		if (prodprod.getStockLevel() <=10){
			graph.setPie(prodprod.getProductName() + " " + prodprod.getStockLevel() + " products remaining ",prodprod.getStockLevel());
		}		
		database.persistData(prodprod);
	}
	
	//Read
	@Override
	public List<Product> getProductByKeyword(String keyword){ 
		ArrayList<Product> productList = (ArrayList)converter.convertToProducts(database.returnData("Product"));
		List<Product> keywordProduct = new ArrayList<Product>();
		
		for (Product p: productList){
			if (p.getProductName().toLowerCase().contains(keyword.toLowerCase()) || p.getDescription().toLowerCase().contains(keyword.toLowerCase())){
				keywordProduct.add(p);
				System.out.println(p.getProductName());
			}
			
		}
		return keywordProduct;
	}
	
	@Override
	public Product getProductByName(String name){
		ArrayList<Product> productList = (ArrayList)converter.convertToProducts(database.returnData("Product"));
		Product prod = new Product();
		for (Product p: productList){
			if (p.getProductName() == name)
			{
				prod = p;				
			}
		}
		return prod;
	}
	
	@Override
	public Product getProductByID(int id){
		ArrayList<Product> productList = (ArrayList)converter.convertToProducts(database.returnData("Product"));
		Product prod = new Product();
		for (Product p: productList){
			if (p.getProductID() == id)
			{
				prod = p;
			}
		}
		return prod;
	}
	
	@Override
	public int getStockLevel(int id){
		ArrayList<Product> productList = (ArrayList)converter.convertToProducts(database.returnData("Product"));
		int stockLevel=-1;
		Product prod = new Product();
		for (Product p: productList){
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
		ArrayList<Product> productList = (ArrayList)converter.convertToProducts(database.returnData("Product"));
		for (Product p: productList){
			if (p.getProductID() == id)
			{
				p.setStockLevel(p.getStockLevel()+quantity);
			}
		}
		
	}
		
	
	
	@Override
	public void decrementStock(int id, int quantity){
		ArrayList<Product> productList = (ArrayList)converter.convertToProducts(database.returnData("Product"));
		for (Product p: productList){
			if (p.getProductID() == id)
			{
				p.setStockLevel(p.getStockLevel()-quantity);
			}
		}
		
	}
	
    @Override
	public List<Product> findAll(){
    	ArrayList<Product> productList = (ArrayList)converter.convertToProducts(database.returnData("Product"));
    	List<Product> products = new ArrayList<Product>();
    	for (Product p : productList)
    		if(p.isDeleted() == false)
    		{
    			products.add(p);
    		}
    	return products;
    	
    }

	@Override
	public List<Product> findCritical() {
		ArrayList<Product> productList = (ArrayList)converter.convertToProducts(database.returnData("Product"));
		List<Product> products = new ArrayList<Product>();
		for (Product p : productList)
		{
			if (p.getStockLevel() <= 10){
				products.add(p);
			}
		}
		return products;
	}
	
	@Override
	public List<Product> findCriticalPourous() {
		ArrayList<Product> productList = (ArrayList)converter.convertToProducts(database.returnData("Product"));
		List<Product> products = new ArrayList<Product>();
		for (Product p : productList)
		{
			if (p.getPorousStockLevel() <= 10){
				products.add(p);
			}
		}
		return products;
	}

	@Override
	public void deleteProduct(int id) {
		ArrayList<Product> productList = (ArrayList)converter.convertToProducts(database.returnData("Product"));
		for(Product p : productList)
		{
			if (p.getProductID() == id)
			{
				p.setDeleted(true);
				if (p.getStockLevel()<=10){graph.removeSegment(p.getProductName() + " " + p.getStockLevel() + " products remaining ");}
				if (p.getPorousStockLevel()<=10){graph.removeSegment3(p.getProductName() + " " + p.getPorousStockLevel() + " products remaining ");}
				database.persistUpdate(p);
			}
		}
		
	}
	
	


	
}
