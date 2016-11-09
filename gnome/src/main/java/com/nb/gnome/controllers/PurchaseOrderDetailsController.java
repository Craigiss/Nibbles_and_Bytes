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
	private List<PurchaseOrderDetails> listPOD;
	private Product product;
	private int quantity;
		
	{
		listPOD = new ArrayList<PurchaseOrderDetails>();
	}
	
	public void addLine(){
		if ((quantity > 0) &&(product !=null)){
			System.out.println(product.getProductName() + " " + quantity);
			listPOD.add(new PurchaseOrderDetails(product, quantity));
		}
		
	}
	
	public void clean(){
		System.out.println("Cleaning the 'Add new PO' form");
		listPOD = new ArrayList<PurchaseOrderDetails>();
		product = null;
		quantity = 0;
	}

	/**
	 * @return the listPOD
	 */
	public List<PurchaseOrderDetails> getListPOD() {
		return listPOD;
	}

	/**
	 * @param listPOD the listPOD to set
	 */
	public void setListPOD(List<PurchaseOrderDetails> listPOD) {
		this.listPOD = listPOD;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	
	
}
