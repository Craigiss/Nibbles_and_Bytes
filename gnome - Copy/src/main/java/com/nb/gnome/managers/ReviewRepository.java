package com.nb.gnome.managers;

import java.util.List;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Review;

/**
 * Interface for PurchaseOrderManager classes
 * PurchaseOrderManagers will have these methods
 * @author Nibbles and Bytes
 */

public interface ReviewRepository {
	//Create
	public void persistReview(Review a);
	//Read
	public List<Review> findReviewByProduct(Product p);
	//Update 
	public void updateReview(Review c);
	List<Product> findAll(); 
	

}
