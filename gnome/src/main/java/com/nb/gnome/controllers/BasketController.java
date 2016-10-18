package com.nb.gnome.controllers;

import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Product;
import com.nb.gnome.managers.ProductRepository;


@Named("Basket")
@SessionScoped
public class BasketController {
	ArrayList<Integer> ids;
	
	@Inject
	ProductRepository productManager;
	
	ArrayList<Product> products = new ArrayList<Product>();
	
	public void addProduct(int id){
		ids.add(id);
	}
	
	public String fillBasket(){

		
		
		if (ids.size() == 0){									// If no products exist in basket
			return "Basket"; 										
			}
		
		for (int s : ids){										// If items exist then match the basket ids with the products.
			products.add(productManager.getProductByID(s));
		}
		
		return "Basket";
	}

	/**
	 * @param products the products to set
	 */
	
	public ArrayList<Product> getProducts() {
		return this.products;
	}
		
	
}
