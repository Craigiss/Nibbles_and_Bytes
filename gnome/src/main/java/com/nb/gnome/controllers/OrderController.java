package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.service.OrderService;


@Named ("order")
@SessionScoped
public class OrderController implements Serializable {
	@Inject 
	OrderService orderService; 

	
	
	private ArrayList<SalesOrder> products = new ArrayList<SalesOrder>();

	public ArrayList<SalesOrder> getProducts() {
		products = orderService.retrieveOrders();
		return products;
	}

	public void setProductss(ArrayList<SalesOrder> products) {
		this.products = products;
	}



}

