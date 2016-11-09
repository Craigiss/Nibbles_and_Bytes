package com.nb.gnome.service;



import java.util.List;
import java.time.LocalDate;

import javax.ejb.Stateful;
import javax.inject.Inject;

import com.nb.gnome.controllers.SelectedProduct;
import com.nb.gnome.entities.Review;
import com.nb.gnome.managers.CustomerRepository;
import com.nb.gnome.managers.ReviewRepository;

import connection.Connection;
@Stateful 
public class ReviewService {
		@Inject 
		ReviewRepository reviewRepository; 
		@Inject 
		SelectedProduct selectedProduct; 
		@Inject 
		UserCredentials user;
		@Inject 
		CustomerRepository customerManager; 
		@Inject 
		Connection connection;
		
		
		
		
		public void completeReview(String Comment, int score){
			int c = 0;
			int total = 0;
			Review r = new Review(); 

			r.setProductID(selectedProduct.getProduct().getProductID());
			r.setDate(LocalDate.now().toString());
			r.setRating(score);
			r.setReviewText(Comment);
			r.setName(user.getUser());
			r.setFKCustomerid(customerManager.getCustomerById(user.getId()));
			r.setProduct_id(selectedProduct.getProduct());
			reviewRepository.persistReview(r);
			List<Review> reviews = reviewRepository.findReviewByProduct(selectedProduct.getProduct());
			for(Review a: reviews){
				c++;
				total += a.getRating();
				
			}
			total = total/c;
			selectedProduct.getProduct().setRating(total);
			connection.persistUpdate(selectedProduct.getProduct());
		}

}
