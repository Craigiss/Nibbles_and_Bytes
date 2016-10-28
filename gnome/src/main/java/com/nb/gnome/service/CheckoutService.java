package com.nb.gnome.service;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateful;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.entities.SalesOrderDetails;
import com.nb.gnome.managers.CustomerRepository;
import com.nb.gnome.managers.SalesOrderDetailsRepository;
import com.nb.gnome.managers.SalesOrderRepository;
@Stateful
public class CheckoutService  {
	private SalesOrder order; 
	private SalesOrderDetails salesOrderDetails;
	private SalesOrderRepository salesOrderManager; 
	private SalesOrderDetailsRepository salesOrderDetailsManager; 
	private CustomerRepository customerManager; 
	
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
		order.setId(salesOrderManager.findAll().size()+1);	
		for (Product p: products){
			salesOrderDetails.setFKSalesOrderId(order.getId());
			salesOrderDetails.setId(salesOrderDetailsManager.findAll().size()+1);
			salesOrderDetails.setProductId(p.getProductID());
			salesOrderDetails.setQuantity(p.getQuantity());
		order.setCustomer(customerManager.getCustomerById(i));
		order.setDate(LocalDate.now().toString());
		order.setStatus("Active");
		salesOrderManager.persistSalesOrder(order);
		}
	
	}
}
