package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import com.nb.gnome.helper.*;
import com.nb.gnome.managers.ProductRepository;
import com.nb.gnome.managers.ReviewRepository;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Review;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

@Named("products")
@ManagedBean
@SessionScoped
public class ProductController implements Serializable {
	@Inject
	private ProductRepository productRepository;
	@Inject 
	private ReviewRepository reviewRepository;
	@Inject
	private SelectedProduct product;
	private PaginationHelper pagination;
	private int selected;
	private DataModel<Product> dataModel = null;
	private List<Review> reviewModel =null;
	private void recreateModel() {
		dataModel = null;
	}
	private String selectedComboItem;
	private static Map<String,Integer> availableItems;
	
	static{
		availableItems = new LinkedHashMap<String, Integer>();
		for(int i =1;i<10;i++)
			availableItems.put(""+i,i );

	}
	
	/**
	 * @return the selectedComboItem
	 */
	public String getSelectedComboItem() {
		return selectedComboItem;
	}


	/**
	 * @param selectedComboItem the selectedComboItem to set
	 */
	public void setSelectedComboItem(String selectedComboItem) {
		this.selectedComboItem = selectedComboItem;
	}


	/**
	 * @return the availableItems
	 */
	public Map<String, Integer> getAvailableItems() {
		return availableItems;
	}


	/**
	 * @param availableItems the availableItems to set
	 */
	public void setAvailableItems(Map<String, Integer> availableItems) {
		this.availableItems = availableItems;
	}


	public PaginationHelper getPagination() {
		if (pagination == null)
		
			pagination = new PaginationHelper(8) {
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
	public List<Review> getReviewModel(){
		if (reviewModel == null){
			return null;
		}
		return reviewModel;
		
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
		product.setProduct(productRepository.getProductByID(id));
		reviewModel = reviewRepository.findReviewByProduct(productRepository.getProductByID(id));
		if(reviewModel.size() == 0)
			reviewModel = null;
		return "Product";
	}
	
}