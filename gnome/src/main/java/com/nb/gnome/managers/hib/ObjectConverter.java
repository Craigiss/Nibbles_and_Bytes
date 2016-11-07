package com.nb.gnome.managers.hib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Review;
import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.entities.SalesOrderDetails;
import com.nb.gnome.entities.Supplier;

@Stateless
public class ObjectConverter implements Serializable {

	public List<Supplier> convertToSuppliers(List<Object> objectList) {
		List<Supplier> supplierList = new ArrayList<Supplier>();

		for (Object o : objectList) {
			supplierList.add((Supplier) o);
		}
		return supplierList;
	}

	public List<Product> convertToProducts(List<Object> objectList) {
		List<Product> productList = new ArrayList<Product>();

		for (Object o : objectList) {
			productList.add((Product) o);
		}
		return productList;
	}
	public List<Address> convertToAddress(List<Object> objectList) {
		List<Address> productList = new ArrayList<Address>();

		for (Object o : objectList) {
			productList.add((Address) o);
		}
		return productList;
	}

	public List<Review> convertToReview(List<Object> objectList) {
		List<Review> reviewList = new ArrayList<Review>();

		for (Object o : objectList) {
			reviewList.add((Review) o);
		}
		return reviewList;
	}

	public List<SalesOrderDetails> convertToSalesOrderDetails(List<Object> objectList) {
		List<SalesOrderDetails> salesOrderDetailsList = new ArrayList<SalesOrderDetails>();

		for (Object o : objectList) {
			salesOrderDetailsList.add((SalesOrderDetails) o);
		}
		return salesOrderDetailsList;
	}

	public List<SalesOrder> convertToSalesOrder(List<Object> objectList) {
		List<SalesOrder> salesOrderList = new ArrayList<SalesOrder>();
		
		for (Object o : objectList) {
			salesOrderList.add((SalesOrder) o);
		}
		
		return salesOrderList;
	}
}