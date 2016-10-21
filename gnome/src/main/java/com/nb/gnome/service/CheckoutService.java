package com.nb.gnome.service;

import java.util.ArrayList;

import com.nb.gnome.entities.Product;

public class CheckoutService {
	
	public double totalPrice(ArrayList<Product> products){
		double total = 0;
		
		for (Product p : products){
			total += (p.getPrice()*p.getQuantity());
		}
		
		
		return total;
		
	}
}
