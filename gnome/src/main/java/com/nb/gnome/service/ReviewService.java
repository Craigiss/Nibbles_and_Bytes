package com.nb.gnome.service;

import java.time.LocalDate;

import javax.ejb.Stateful;
import javax.inject.Inject;

import com.nb.gnome.controllers.SelectedProduct;
import com.nb.gnome.entities.Review;
import com.nb.gnome.managers.ReviewRepository;
@Stateful 
public class ReviewService {
		@Inject 
		ReviewRepository reviewRepository; 
		@Inject 
		SelectedProduct selectedProduct; 
		
		
		public void completeReview(String Comment, int score){
			Review r = new Review(); 
			r.setProductID(selectedProduct.getProduct().getProductID());
			r.setDate(LocalDate.now().toString());
			r.setRating(score);
			r.setReviewText(Comment);
			reviewRepository.persistReview(r);
		}

}
