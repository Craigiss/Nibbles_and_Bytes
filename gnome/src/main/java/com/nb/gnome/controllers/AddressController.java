package com.nb.gnome.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Address;
import com.nb.gnome.service.AddressService;

@Named(value = "addresses")
@SessionScoped
public class AddressController implements Serializable {
	
	@Inject
	private AddressService addressService;
	private String line1;
	private String line2;
	private String town;
	private String county;
	private String postcode;
	
	public Address persistAddress(){
		Address newAddress = new Address(line1, line2, town, county, postcode);
		addressService.persistAddress(newAddress);
		return newAddress;
	}
	
	/**
	 * @return the line1
	 */
	public String getLine1() {
		return line1;
	}
	/**
	 * @param line1 the line1 to set
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	/**
	 * @return the line2
	 */
	public String getLine2() {
		return line2;
	}
	/**
	 * @param line2 the line2 to set
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	/**
	 * @return the town
	 */
	public String getTown() {
		return town;
	}
	/**
	 * @param town the town to set
	 */
	public void setTown(String town) {
		this.town = town;
	}
	/**
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}
	/**
	 * @param county the county to set
	 */
	public void setCounty(String county) {
		this.county = county;
	}
	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	
}
