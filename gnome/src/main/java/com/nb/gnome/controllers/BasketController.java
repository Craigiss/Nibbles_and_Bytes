package com.nb.gnome.controllers;

import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Product;
import com.nb.gnome.managers.ProductRepository;

import javassist.compiler.ast.Pair;

import java.io.Serializable;


@Named("Basket")
@SessionScoped
public class BasketController implements Serializable {
	public class item{
		int id;
		int quantity;
		public item(int id, int quantity){
			this.id = id;
			this.quantity = quantity;
		}
	}
	
	ArrayList<item> ids;

	@Inject
	ProductRepository productManager;
	
	ArrayList<Product> products = new ArrayList<Product>();
	
	public void addProduct(int id, int quantity){
		if(ids == null){
			ids = new ArrayList<item>();
		}
		ids.add(new item(id,quantity));
	}
	
	public String fillBasket(){
		if(ids == null){
			ids = new ArrayList<item>();
			return "Basket"; 
		}		
		if (ids.size() == 0){									// If no products exist in basket
			return "Basket"; 										
		}

		for (item s : ids){										// If items exist then match the basket ids with the products.
			Product p = productManager.getProductByID(s.id);
			p.setQuantity(s.quantity);
			
			products.add(p);
		}
		ids = null;
		return "Basket";
	}
	
	public String UpdatePrice(String quantity, Double Price){
		
		Double quan = Double.parseDouble(quantity);
		quan = Price * quan;
		return "" + quan;
		
	}

	/**
	 * @param products the products to set
	 */
	
	public ArrayList<Product> getProducts() {
		return this.products;
	}
		
	
}
