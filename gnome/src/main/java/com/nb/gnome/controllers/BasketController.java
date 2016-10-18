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
	
	
	public void addProduct(int id){
		ids.add(id);
	}
	
	public ArrayList<Product> getProducts(){

		ArrayList<Product> p = new ArrayList<Product>();
		
		if (ids.size() == 0){									// If no products exist in basket
			return null; 										// Return null
			}
		
		for (int s : ids){										// If items exist then match the basket ids with the products.
			p.add(productManager.getProductByID(s));
		}
		
		return(p);
	}
			
}
