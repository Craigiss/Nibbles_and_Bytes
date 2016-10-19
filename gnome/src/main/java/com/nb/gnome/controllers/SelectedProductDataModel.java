package com.nb.gnome.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.inject.Named;

import com.nb.gnome.entities.Product;

@Named("productModel")
@SessionScoped
public class SelectedProductDataModel implements Serializable {
	private DataModel<Product> productDataModel;

	/**
	 * @return the productDataModel
	 */
	public DataModel<Product> getProductDataModel() {
		return productDataModel;
	}

	/**
	 * @param productDataModel the productDataModel to set
	 */
	public void setProductDataModel(DataModel<Product> productDataModel) {
		this.productDataModel = productDataModel;
	}
	
	
	
	
}
