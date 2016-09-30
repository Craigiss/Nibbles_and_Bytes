package com.nb.gnome.entities;

import java.util.List;

import javax.persistence.*;

/**
 * @author Nibbles and Bytes
 * @version 1.0
 * 
 *          This class is for the suppliers used by NB Gardens business and uses
 *          variables to model the data needed for the system.
 **/
@Deprecated
public class CustomerAccountAddress {
	// Connor
	@OneToMany
	@JoinColumn(name="username_fk", nullable = false)
	private CustomerAccount username;
	
	@ManyToOne
	@JoinColumn(name="address_fk", nullable = false)
	private List<Address> address;

	/**
	 * @return the username
	 */
	@Deprecated
	public CustomerAccount getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	@Deprecated
	public void setUsername(CustomerAccount username) {
		this.username = username;
	}

	/**
	 * @return the address
	 */
	@Deprecated
	public List<Address> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	@Deprecated
	public void setAddress(List<Address> address) {
		this.address = address;
	}
}