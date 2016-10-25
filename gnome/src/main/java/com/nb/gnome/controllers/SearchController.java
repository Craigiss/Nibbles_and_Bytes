package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Product;

@Named("search")
@SessionScoped
public class SearchController implements Serializable {
	
	
	private ArrayList<Product> products = new ArrayList<Product>();
	@Inject ProductController productController;
	private SelectedProduct selectedProduct;
	private Product product;
	private String term;
	
	
	public String search(){
		
		Product p1 = new Product();
		p1.setProductName("King of the 7 Gnomedoms");
		p1.setProductID(1);
		p1.setImgPath("img/GameofGnomes.jpg");
		p1.setDescription("Every now and again a piece of wordplay comes along that's so sumptuous, so irresistible that it would be a travesty to not bring it to life (Robocup anyone?). We present to you... Game of Gnomes. The original may have been forged from a thousand swords in the fiery exhalation of a dragon named 'Balerion the Black Dread', but this slightly diminutive version is appropriately made up of an assortment of rusty gardening tools.");
		p1.setPrice(17.99);
		p1.setStockLevel(115);
		products.add(p1);
		
		Product p2 = new Product();
		p2.setProductName("The Laundry Line");
		p2.setProductID(2);
		p2.setImgPath("img/Laundry.gif");
		p2.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden");
		p2.setPrice(2.99);
		p2.setStockLevel(115);
		products.add(p2);
		
		products.add(p1);
		products.add(p2);
		
		productController.getDataModel();
		productController.setDataModel(products);
		
		
		
		
		
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