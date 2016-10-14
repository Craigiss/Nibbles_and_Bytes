package com.nb.gnome.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import com.nb.gnome.helper.*;
import com.nb.gnome.managers.ProductRepository;
import com.nb.gnome.entities.Product;

@Named("products")
@SessionScoped
public class ProductController implements Serializable {
	@Inject
	private ProductRepository productRepository;
	private Product product;
	private PaginationHelper pagination;
	private int selected;
	private DataModel<Product> dataModel = null;

	private void recreateModel() {
		dataModel = null;
	}

	public PaginationHelper getPagination() {
		if (pagination == null)
			pagination = new PaginationHelper(2) {
				@Override
				public int getItemsCount() {
					return productRepository.findAll().size();
				}

				@Override
				public DataModel<Product> createPageDataModel() {
					try {
						return new ListDataModel<Product>(
								productRepository.findAll().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(
								productRepository.findAll().subList(getPageFirstItem(), getItemsCount()));
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
	
	public String view (int id){
		product = productRepository.getProductByID(id);
		return "product";
	}
	
	public Product getProduct(){
		return product;
	}
	
	public void setProduct(Product product){
		this.product = product; 
	}

}
