package com.nb.gnome.service;

import java.util.ArrayList;

import javax.ejb.Stateful;

import com.nb.gnome.entities.Product;
@Stateful
public class CheckoutService  {
	
	public double totalPrice(ArrayList<Product> products){
		double total = 0;
		
		for (Product p : products){
			total += (p.getPrice()*p.getQuantity());
		}
		String totalP = String.format("%1$.2f", total);
		total = Double.parseDouble(totalP);
		return total;
		
	}
}
