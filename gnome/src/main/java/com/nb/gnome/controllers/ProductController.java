package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import com.nb.gnome.helper.*;
import com.nb.gnome.managers.ProductRepository;
import com.nb.gnome.service.ProductService;
import com.nb.gnome.entities.Product;

@Named("products")
@SessionScoped
public class ProductController implements Serializable {
	
	//Convert to ProductService - gots to make sure that this is a Service object, not a Manager!!!!
	@Inject
	private ProductService productService;
	
	@Inject private SelectedProduct product;
	private PaginationHelper pagination;
	private DataModel<Product> dataModel = null;
	private Product nproduct;
	private int productID;
	private String name;
	private String description;
	private double price;
	private int stockLevel;
	private int porousStockLevel;

	private void recreateModel() {
		dataModel = null;
	}
	
	public String reset(){
		dataModel = null;
		return "imsIndex";
				
	}

	public PaginationHelper getPagination() {
		if (pagination == null)
			pagination = new PaginationHelper(2) {
				@Override
				public int getItemsCount() {
					if (dataModel == null){
					  return productService.findAll().size();
					}
					else {
						return dataModel.getRowCount() + (pagination.getPage() * pagination.getPageSize());
					}
					
					
				}

				@Override
				public DataModel<Product>createPageDataModel() {
					try {
						return new ListDataModel<Product>(
								productService.findAll().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(
								productService.findAll().subList(getPageFirstItem(), getItemsCount()));
					}
				}

			};

		return pagination;
	}

	public DataModel<Product> getDataModel() {
		if (dataModel == null)
			dataModel = getPagination().createPageDataModel();
		return dataModel;
	}
	
	public void setData(ArrayList<Product> model ){
		dataModel.setWrappedData(model);
	}
	
	public String next(){
		getPagination().nextPage();
		recreateModel();
		return "browse";
	}
	
	public String previous(){
		getPagination().previousPage();
		recreateModel();
		return "browse";
	}
	
	public String view (Product p){
		product.setProduct(p);
		return "imsProdDeets";
	}
	
	public String persistProduct(){
		productService.persistProduct(name, description, price, stockLevel, porousStockLevel);
		recreateModel();
		name="";
		description="";
		price=0;
		stockLevel=0;
		porousStockLevel=0;
		return "imsProducts";
	}
	
	public List<Product> findAll(){
		return productService.findAll();
	}

	/**
	 * @return the nproduct
	 */
	public Product getNproduct() {
		return nproduct;
	}

	/**
	 * @param nproduct the nproduct to set
	 */
	public void setNproduct(Product nproduct) {
		this.nproduct = nproduct;
	}

	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}

	/**
	 * @param productID the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the stockLevel
	 */
	public int getStockLevel() {
		return stockLevel;
	}

	/**
	 * @param stockLevel the stockLevel to set
	 */
	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}
	
	

	/**
	 * @return the porousStockLevel
	 */
	public int getPorousStockLevel() {
		return porousStockLevel;
	}

	/**
	 * @param porousStockLevel the porousStockLevel to set
	 */
	public void setPorousStockLevel(int porousStockLevel) {
		this.porousStockLevel = porousStockLevel;
	}

	/**
	 * @return the product
	 */
	public SelectedProduct getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(SelectedProduct product) {
		this.product = product;
	}	
	
	
}
