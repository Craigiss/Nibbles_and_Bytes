package com.nb.gnome.mangers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Review;
import com.nb.gnome.managers.ReviewRepository;

import gnome.InitialData;
@Default
@Stateless
public class ReviewRepositoryOffline implements ReviewRepository {
	@Inject
	private InitialData initialData;
	@Override
	public void persistReview(Review a) {
		initialData.addReview(a);
	}

	@Override
	public List<Review> findReviewByProduct(Product p) {
		List<Review> list = new ArrayList<Review>();
		for(Review r: initialData.getReviews()){
			if(r.getProductid() == p.getProductID()){
				list.add(r);
			}
		}
		return list;
	}

	 @Override
		public List<Product> findAll(){
	    	List<Product> p = initialData.getProducts();
	    	
	    	return p;
	    	
	    }

	
	
	
	
	//Not been done
	@Override
	public void updateReview(Review c) {
		
		
	}

}
