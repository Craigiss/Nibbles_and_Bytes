package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.managers.AddressRepository;
import com.nb.gnome.service.OrderService;


@Named ("order")
@SessionScoped
public class OrderController implements Serializable {
	@Inject 
	OrderService orderService; 
	@Inject 
	AddressRepository addressManager;
	
    private Address savedAddress;
    private int selectedId;
	private String addressSecondLine;
	private String addressFirstLine;
	private String town;
	private String county; 
	private String postcode; 
	
	private ArrayList<SalesOrder> products = new ArrayList<SalesOrder>();

	public ArrayList<SalesOrder> getProducts() {
		products = orderService.retrieveOrders();
		return products;
	}

	public void setProductss(ArrayList<SalesOrder> products) {
		this.products = products;
	}

	public String saveAddress(int id){
		savedAddress = new Address();
		savedAddress = addressManager.getAddressById(id);
		addressSecondLine = savedAddress.getLine2();
		addressFirstLine = savedAddress.getLine1();
		town = savedAddress.getTown();
		county = savedAddress.getCounty();
		postcode = savedAddress.getPostcode();
		return "OrderConfirmation";
		
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

	public void setProducts(ArrayList<SalesOrder> products) {
		this.products = products;
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
	
	


}

