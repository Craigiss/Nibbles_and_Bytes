package com.nb.gnome.service;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.inject.Inject;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.entities.SalesOrderDetails;
import com.nb.gnome.managers.CustomerRepository;
import com.nb.gnome.managers.SalesOrderDetailsRepository;
import com.nb.gnome.managers.SalesOrderRepository;
@Stateful
public class CheckoutService  {
	
	
	@Inject 
	private SalesOrderRepository salesOrderManager; 
	@Inject
	private SalesOrderDetailsRepository salesOrderDetailsManager; 
	@Inject
	private CustomerRepository customerManager; 
	
	int mostRecentOrderID = -1;
	
	public double totalPrice(ArrayList<Product> products){
		double total = 0;
		
		for (Product p : products){
			total += (p.getPrice()*p.getQuantity());
		}
		String totalP = String.format("%1$.2f", total);
		total = Double.parseDouble(totalP);
		return total;
		
	}
	
	public void completeOrder(ArrayList<Product> products, int i){
		SalesOrder order = new SalesOrder();
		SalesOrderDetails salesOrderDetails = new SalesOrderDetails();
		order.setId(salesOrderManager.findAll().size()+1);	
		for (Product p: products){
			salesOrderDetails.setFKSalesOrderId(order.getId());
			salesOrderDetails.setId(salesOrderDetailsManager.findAll().size()+1);
			salesOrderDetails.setProductId(p.getProductID());
			salesOrderDetails.setQuantity(p.getQuantity());
			salesOrderDetailsManager.persistSalesOrderDetails(salesOrderDetails);
		order.setCustomer(customerManager.getCustomerById(i));
		order.setDate(LocalDate.now().toString());
		order.setStatus("Processing");
		salesOrderManager.persistSalesOrder(order);
		mostRecentOrderID = salesOrderManager.findAll().size();
		}
		

	}
	public String getCompletedOrderID(){
		return Integer.toString(mostRecentOrderID);
	}
}
