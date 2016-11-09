package com.nb.gnome.managers.hib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.Category;
import com.nb.gnome.entities.Customer;
import com.nb.gnome.entities.ISAccount;
import com.nb.gnome.entities.Product;

import com.nb.gnome.entities.ProductCategory;

import com.nb.gnome.entities.Returns;
import com.nb.gnome.entities.Review;
import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.entities.SalesOrderDetails;



@Stateless
public class ObjectConverter implements Serializable {




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

	public List<Category> ConvertToCategory(List<Object> objectList){
		List<Category> categoryList = new ArrayList<Category>();
		
		for (Object o: objectList){
			categoryList.add((Category)o);
		}
		
		return categoryList;
		
	}
	
	public List<ProductCategory> ConvertToProductCategory(List<Object> objectList){
		List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
		
		for (Object o: objectList){
			productCategoryList.add((ProductCategory)o);
		}
		
		return productCategoryList;
		
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

	public List<Returns> convertToReturns(List<Object> objectList) {
		List<Returns> returnsList = new ArrayList<Returns>();
		
		for (Object o : objectList) {
			returnsList.add((Returns) o);
		}
		
		return returnsList;
	}
	public List<ISAccount> convertToISA(List<Object> returnData) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Customer> convertToCustomer(List<Object> objectList) {
		List<Customer> returnsList = new ArrayList<Customer>();
		
		for (Object o : objectList) {
			returnsList.add((Customer) o);
		}
		
		return returnsList;
	}

}