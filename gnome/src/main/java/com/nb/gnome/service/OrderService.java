package com.nb.gnome.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.managers.CustomerRepository;
import com.nb.gnome.managers.SalesOrderRepository;

@Stateless 
public class OrderService {
	@Inject
	SalesOrderRepository salesOrderManager;
    @Inject 
    UserCredentials userCredentials;
    @Inject
    CustomerRepository customerManager;
	
    public ArrayList<SalesOrder> retrieveOrders(){
		ArrayList<SalesOrder> p = new ArrayList<SalesOrder>();
		p = salesOrderManager.findSalesOrderByCustomer(customerManager.getCustomerByEmail(userCredentials.getEmail()));
		
		return p;
		
	}
    
    public void cancelOrder(int id){
    	
    	SalesOrder a = salesOrderManager.findSalesOrderById(id);
    	a.setStatus("Cancelled");
    	salesOrderManager.updateOrder(a);
    	
    }
}
