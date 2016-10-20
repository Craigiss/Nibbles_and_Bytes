package com.nb.gnome.controllers;

import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Product;
import com.nb.gnome.managers.ProductRepository;
import com.nb.gnome.service.UserCredentials;

import javassist.compiler.ast.Pair;

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
	
	ArrayList<item> ids = new ArrayList<item>();

	@Inject
	ProductRepository productManager;
	@Inject 
	UserCredentials userCredentials; 
	
	ArrayList<Product> products = new ArrayList<Product>();
	
	public void addProduct(int id, int quantity,double cost){
		if(ids == null){
			ids = new ArrayList<item>();
		}
		cost = cost * quantity;
		ids.add(new item(id,quantity,cost));
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
		ids = null;
		
		return "Basket";
	}
	
	public String UpdatePrice(String quantity, Double Price){
		
		Double quan = Double.parseDouble(quantity);
		quan = Price * quan;
		
		return String.format("%1$.2f", quan);
		
	}

	/**
	 * @param products the products to set
	 */
	
	public ArrayList<Product> getProducts() {
		return this.products;
	}
	public String ClearBasket(){
		products = new ArrayList<Product>();
		return "Basket";
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
		
			return "Checkout";
		}
	}
	
}
