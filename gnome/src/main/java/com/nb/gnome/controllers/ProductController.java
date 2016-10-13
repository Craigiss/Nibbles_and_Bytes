package com.nb.gnome.controllers;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Product;

import gnome.ProductRepository;

@Named("products")
@SessionScoped
public class ProductController implements Serializable {
	@Inject 
	private ProductRepository prodManager; 
	private Product product; 
	private PaginatorHelper pagination; 
	private int selected;
	private DataModel<Product> dataModel = null;
	
	private void recreateModel(){
		dataModel = null; 
	}
	
	public PagenationHelper getPagination(){
		if (pagination == null){
			pagination = new PagenationHelper(10){
				@Override public int getItensCount(){
					return prodManager.findAll().size();
				}
			}
		}
	}
	
	
}
