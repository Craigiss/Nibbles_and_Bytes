package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.PurchaseOrderDetails;

@Named (value="pods")
@SessionScoped
public class PurchaseOrderDetailsController implements Serializable{
	private List<Product> listProducts;
	private List<Integer> listQuantities;
		
	{
		listProducts = new ArrayList<Product>();
		listProducts.add(new Product());
	}
	
	public void extend(){
		listProducts.add(new Product());
	}
	
	
	/**
	 * Converts attributes into a list of PurchaseOrderDetails
	 * @return
	 */
	public List<PurchaseOrderDetails> convert(){
		List<PurchaseOrderDetails> list = new ArrayList<PurchaseOrderDetails>();
		for(int i = 0; i < listProducts.size(); i++){
			System.out.println(listProducts.get(i).getProductName());
			PurchaseOrderDetails a = new PurchaseOrderDetails(listProducts.get(i), listQuantities.get(i));
			list.add(a);
		}

		return list;
	}
	
	public void clean(){
		System.out.println("Cleaning the 'Add new PO' form");
		listProducts = new ArrayList<Product>();
		listQuantities = new ArrayList<Integer>();
	}

	/**
	 * @return the listProducts
	 */
	public List<Product> getListProducts() {
		return listProducts;
	}


	/**
	 * @param listProducts the listProducts to set
	 */
	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}


	/**
	 * @return the listQuantities
	 */
	public List<Integer> getListQuantities() {
		return listQuantities;
	}


	/**
	 * @param listQuantities the listQuantities to set
	 */
	public void setListQuantities(List<Integer> listQuantities) {
		this.listQuantities = listQuantities;
	}
	
	
	
}
