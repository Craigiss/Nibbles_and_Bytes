package com.nb.gnome.controllers;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import com.nb.gnome.helper.*;
import com.nb.gnome.entities.Product;

import gnome.ProductRepository;

@Named("products")
@SessionScoped
public class ProductController implements Serializable {
	@Inject
	private ProductRepository prodManager;
	private Product product;
	private PaginationHelper pagination;
	private int selected;
	private DataModel<Product> dataModel = null;

	private void recreateModel() {
		dataModel = null;
	}

	public PaginationHelper getPagination() {
		if (pagination == null)
			pagination = new PaginationHelper(10) {
				@Override
				public int getItemsCount() {
					return prodManager.findAll().size();
				}

				@Override
				public DataModel<Product> createPageDataModel() {
					try {
						return new ListDataModel<Product>(
								prodManager.findAll().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(
								prodManager.findAll().subList(getPageFirstItem(), getItemsCount()));
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

	private void updateCurrentItem() {
		int count = prodManager.findAll().size();
		if (selected >= count) {
			selected = count - 1;
			if (pagination.getPageFirstItem() >= count)
				pagination.previousPage();
		}
		if (selected >= 0)
			try {
				setProduct(prodManager.findAll().subList(selected, selected + 1).get(0));
			} catch (Exception e) {
				setProduct(prodManager.findAll().subList(selected, count).get(0));
			}
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
		product = prodManager.getProductByID(id);
		return "product";
	}
	
	public Product getProduct(){
		return product;
	}
	
	public void setProduct(Product product){
		this.product = product; 
	}

}
