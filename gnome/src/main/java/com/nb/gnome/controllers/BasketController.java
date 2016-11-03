package com.nb.gnome.controllers;

import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Product;
import com.nb.gnome.managers.ProductRepository;
import com.nb.gnome.service.CheckoutService;
import com.nb.gnome.service.UserCredentials;

import java.io.Serializable;


@Named("Basket")
@SessionScoped
public class BasketController implements Serializable {
	
	
	public class item{
		int id;
		int quantity;
		double cost;
		public item(int id, int quantity, double cost){
			this.id = id;
			this.quantity = quantity;
			this.cost = cost;
		}
	}
	String basketName = "Basket";
	/**
	 * @return the basketName
	 */
	public String getBasketName() {
		return basketName;
	}

	/**
	 * @param basketName the basketName to set
	 */
	public void setBasketName(String basketName) {
		this.basketName = basketName;
	}
	ArrayList<item> ids = new ArrayList<item>();
	String submit;
	
	@Inject
	ProductRepository productManager;
	@Inject 
	UserCredentials userCredentials; 
	 @Inject
	CheckoutService checkoutService; 
	private double total; 
	ArrayList<Product> products = new ArrayList<Product>();
	int totalItems =0;
	public void updateBasketName(int quant){
		totalItems += quant;
		basketName = "Basket (" + (totalItems) +")"; 
		
	}
	
	public void addProduct(int id, int quantity,double cost){
		if(ids == null){
			ids = new ArrayList<item>();
		}
		cost = cost * quantity;
		ids.add(new item(id,quantity,cost));
		setSubmit("Item added to basket");
		updateBasketName(quantity);
	}
	public void clearSubmit(){
		setSubmit(null);
	}
	/**
	 * @return the submit
	 */
	public String getSubmit() {
		return submit;
	}

	/**
	 * @param submit the submit to set
	 */
	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String fillBasket(){
		boolean exists =false;
		if(ids == null){
			ids = new ArrayList<item>();
			return "Basket"; 
		}		
		if (ids.size() == 0){									// If no products exist in basket
			return "Basket"; 										
		}

		for (item s : ids){										// If items exist then match the basket ids with the products.
			Product p = productManager.getProductByID(s.id);
			for(Product oldProduct : products){
				if(oldProduct == p){
					oldProduct.setQuantity(oldProduct.getQuantity() + s.quantity);
					exists = true;
				}
			}
			if(!exists){
				p.setQuantity(s.quantity);
				
				products.add(p);
			}
			exists = false;
		}		
		ids = new ArrayList<item>();
		setSubmit(null);
		return "Basket";
	}
	
	public String UpdatePrice(String quantity, Double Price){
		
		Double quan = Double.parseDouble(quantity);
		quan = Price * quan;
		
		return String.format("%1$.2f", quan);
		
	}
	
	

	/**

	 * @return list of products
	 */
	public ArrayList<Product> getProducts() {
		return this.products;
	}
	public String ClearBasket(){
		products = new ArrayList<Product>();
		basketName = "Basket";
		totalItems =0;
		return "Basket";
	}
	
	public String deleteProduct(int productIdToDelete){
		for (Product p : products){
			if(p.getProductID() == productIdToDelete){
				products.remove(p);
				break;
			}
		}

		totalItems--;
		return("Basket");
	}
	
	public String checkout(){
		if (userCredentials.getEmail() == null || userCredentials.getEmail() == " "){
			return "loginPage"; 
		}
		
		if(products.size() <1){
			return "Basket";
		}
		else
		{
			total = checkoutService.totalPrice(products);
			return "Checkout";
		}
	}
	
	public double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	
}
