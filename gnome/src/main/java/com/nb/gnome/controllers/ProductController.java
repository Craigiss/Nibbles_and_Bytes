package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;
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
import com.nb.gnome.service.ReviewService;
import com.nb.gnome.service.UserCredentials;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Review;
import javax.enterprise.context.SessionScoped;

@Named("products")
@ManagedBean
@SessionScoped
public class ProductController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5718567156846919976L;
	@Inject
	private ProductRepository productRepository;
	@Inject 
	private ReviewRepository reviewRepository;
	@Inject
	private SelectedProduct product; 
	@Inject
	private ReviewService reviewService; 
	@Inject 
	private UserCredentials user;
	
	private PaginationHelper pagination;
	private DataModel<Product> dataModel = null;
	private List<Review> reviewModel =null;
	private void recreateModel() {
		dataModel = null;
	}
	private String selectedComboItem;
	private static Map<String,Integer> availableItems;
	private String review; 
	private int score; 
	private String reviewAmount = "";
	
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
	
	public void setDataModel(ArrayList<Product> model){
		dataModel.setWrappedData(model);
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
		return "Search";
	}
	
	public String previous(){
		getPagination().previousPage();
		recreateModel();
		return "Search";
	}
	
	public String view (int id){
		product.setProduct(productRepository.getProductByID(id));
		reviewModel = reviewRepository.findReviewByProduct(productRepository.getProductByID(id));
		
		if(reviewModel.size() == 0)
			reviewModel = null;
		
		reviewAmount = "(" + reviewRepository.findReviewByProduct(product.getProduct()).size() +")"; 
		return "Product";
	}

	public String writeReview(){
		if(user.getEmail() == null){
			return "loginPage";
		}
		reviewService.completeReview( review,score);
		view(product.getProduct().getProductID());
		review = "";
	    score = 0;
		return "Product";
	}

	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getReviewAmount() {
		return reviewAmount;
	}


	public void setReviewAmount(String reviewAmount) {
		this.reviewAmount = reviewAmount;
	}
	
	
	
}
