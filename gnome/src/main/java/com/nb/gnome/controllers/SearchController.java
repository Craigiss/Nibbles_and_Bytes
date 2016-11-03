package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Product;
import com.nb.gnome.managers.ProductRepository;

@Named("search")
@SessionScoped
public class SearchController implements Serializable {
	@Inject
	ProductRepository productManager;
	@Inject 
	SearchCatalogueController searchCatController;
	private ArrayList<Product> products = new ArrayList<Product>();
	
	private String term;
	public String search(){
		products = (ArrayList<Product>) productManager.getProductByKeyword(term);
		
		searchCatController.getDataModel();
		searchCatController.setDataModel(products);
		
		return "Search";
	}
	
	public String openCategoryPage(String searchTerm){
		//categoryTerm = "Gnomes";																
		products = (ArrayList<Product>) productManager.getProductByCategory(searchTerm);
		
		searchCatController.getDataModel();
		searchCatController.setDataModel(products);
		
		return "Search";
	}


	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}


	/**
	 * @param term the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	
	

}