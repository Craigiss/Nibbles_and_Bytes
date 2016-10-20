package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;

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
	
	//Convert to ProductService
	@Inject
	private ProductRepository productService;
	
	@Inject private SelectedProduct product;
	private PaginationHelper pagination;
	private DataModel<Product> dataModel = null;

	private void recreateModel() {
		dataModel = null;
	}
	
	public String reset(){
		dataModel = null;
		return "imsIndex";
				
	}

	public PaginationHelper getPagination() {
		if (pagination == null)
			pagination = new PaginationHelper(10) {
				@Override
				public int getItemsCount() {
					if (dataModel == null){
					  return productService.findAll().size();
					}
					else {
						return dataModel.getRowCount();
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
	
	public String view (int id){
		System.out.println(">>>> selected ID: " + id);
		product.setProduct(productService.getProductByID(id));

		return "Product";
	}
	
}
