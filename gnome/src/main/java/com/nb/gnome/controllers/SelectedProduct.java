package com.nb.gnome.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.nb.gnome.entities.Product;

@Named("selected")
@SessionScoped
public class SelectedProduct implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5219435126829924070L;
	private Product product;
	private int reviewAmount;

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

	public int getReviewAmount() {
		return reviewAmount;
	}

	public void setReviewAmount(int reviewAmount) {
		this.reviewAmount = reviewAmount;
	}	
	
	
}