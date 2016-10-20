package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.helper.PaginationHelper;
import com.nb.gnome.managers.CustomerRepository;
import com.nb.gnome.managers.SalesOrderRepository;
import com.nb.gnome.service.UserCredentials;

@Named ("order")
@SessionScoped
public class OrderController implements Serializable {
	@Inject
	private SalesOrderRepository salesOrderManager;
	@Inject 
	private BasketController basketController; 
	@Inject 
	private UserCredentials userCredentials; 

	
	
	ArrayList<SalesOrder> productss = new ArrayList<SalesOrder>();



	
	/**
	 * @return the productss
	 */
	public ArrayList<SalesOrder> getProductss() {
		return productss;
	}




	/**
	 * @param productss the productss to set
	 */
	public void setProductss(ArrayList<SalesOrder> productss) {
		this.productss = productss;
	}




	public void fillOrders(){
		
		productss = salesOrderManager.findSalesOrderByCustomerID(userCredentials.getId());
		
		
	}

}

