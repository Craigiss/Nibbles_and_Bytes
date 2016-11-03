package com.nb.gnome.controllers;

import java.awt.BasicStroke;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.managers.AddressRepository;
import com.nb.gnome.managers.CustomerRepository;
import com.nb.gnome.service.CheckoutService;
import com.nb.gnome.service.OrderService;
import com.nb.gnome.service.UserCredentials;


@Named ("order")
@SessionScoped
public class OrderController implements Serializable {
	@Inject 
	OrderService orderService; 
	@Inject 
	AddressRepository addressManager;
	@Inject
	CheckoutService checkoutService; 
	@Inject 
	BasketController basketController;
	@Inject 
	UserCredentials  userCredentials; 
	@Inject 
	CustomerRepository customerManager; 
	
    private Address savedAddress;
    private int selectedId;
	private String addressSecondLine;
	private String addressFirstLine;
	private String town;
	private String county; 
	private String postcode; 
	
	private ArrayList<SalesOrder> salesOrders = new ArrayList<>();
	
	

	/**
	 * @return the products
	 */
	public ArrayList<SalesOrder> getSalesOrders() {
		salesOrders = orderService.retrieveOrders();
		return salesOrders;
	}

	/**
	 * @param products the products to set
	 */
	public void setSalesOrders(ArrayList<SalesOrder> products) {
	
		this.salesOrders = products;
	}

	public String saveAddress(int id){
		List <Address> Address = customerManager.getCustomerById(userCredentials.getId()).getAddresses();
		for(Address a : Address){
			if (a.getId() == id){
				addressSecondLine = a.getLine2();
				addressFirstLine = a.getLine1();
				town = a.getTown();
				county = a.getCounty();
				postcode = a.getPostcode();
				return "OrderConfirmation";}
		}
		return null;
		
	
		
	}
	
	public String completeOrder(){
		checkoutService.completeOrder(basketController.getProducts(), userCredentials.getId());
		basketController.ClearBasket();

		return "OrderSuccess";
	}
	

	public Address getSavedAddress() {
		return savedAddress;
	}

	public void setSavedAddress(Address savedAddress) {
		this.savedAddress = savedAddress;
	}

	public int getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}


	public String getAddressSecondLine() {
		return addressSecondLine;
	}

	public void setAddressSecondLine(String addressSecondLine) {
		this.addressSecondLine = addressSecondLine;
	}

	public String getAddressFirstLine() {
		return addressFirstLine;
	}

	public void setAddressFirstLine(String addressFirstLine) {
		this.addressFirstLine = addressFirstLine;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getOrderID(){
		return checkoutService.getCompletedOrderID();
	}
	


}

