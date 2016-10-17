//Kieran Working On
package com.nb.gnome.controllers;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Product;
import com.nb.gnome.helper.PaginationHelper;
import com.nb.gnome.managers.ProductRepository;
import java.io.Serializable;
@Named("searchProducts")
@SessionScoped
public class SearchCatalogueController extends Searchable implements Serializable {
	@Inject
	private ProductRepository productRepository;
	@Inject
	private SelectedProduct product;
	private PaginationHelper pagination;
	private int selected;
	private DataModel<Product> dataModel = null;

	private void recreateModel() {
		dataModel = null;
	}

	public PaginationHelper getPagination() {
		if (pagination == null)
		
			pagination = new PaginationHelper(12) {
				@Override
				public int getItemsCount() {
					return productRepository.findAll().size();
				}

				@Override
				public DataModel<Product>createPageDataModel() {
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
	
	public String view (String id){
		System.out.println(">>>> selected ID: " + id);
		product.setProduct(productRepository.getProductByID(id));

		return "Product";
	}
}
