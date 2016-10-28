package com.nb.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	
	@Id
	@GeneratedValue 
	private int customerid;
	private String customername;
	
	@OneToMany
	private List<Address> addresses;
	
	
	
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", addresses=" + addresses
				+ "]";
	}

	
	
	
	
	
	
}
