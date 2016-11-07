package com.nb.gnome.mangers.online;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Review;
import com.nb.gnome.managers.ReviewRepository;
import com.nb.gnome.managers.hib.ObjectConverter;

import connection.Connection;
import gnome.InitialData;
@Alternative
@Stateless
public class ReviewRepositoryOnline implements ReviewRepository {
	@Inject
	private Connection connection;

	@Inject
	private ObjectConverter converter;
	
	
	@Override
	public void persistReview(Review a) {
		connection.persistData(a);
	}

	@Override
	public List<Review> findReviewByProduct(Product p) {
		List<Review> list = new ArrayList<Review>();
		for(Review r : converter.convertToReview(connection.returnData("Reviews"))){
			if(r.getProductid() == p.getProductID()){
				list.add(r);
			}
		}
		return list;
	}

	 @Override
		public List<Product> findAll(){
	    	List<Product> p = converter.convertToProducts(connection.returnData("Products"));
	    	return p;
	    }

	
	
	
	
	//Not been done
	@Override
	public void updateReview(Review c) {
		
		
	}

}
