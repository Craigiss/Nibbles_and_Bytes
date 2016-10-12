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

public class CustomerAccountAddress {
	// Connor
	@OneToMany
	@JoinColumn(name="username_fk", nullable = false)
	private Customer username;
	
	@ManyToOne
	@JoinColumn(name="address_fk", nullable = false)
	private List<Address> address;

	/**
	 * @return the username
	 */

	public Customer getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */

	public void setUsername(Customer username) {
		this.username = username;
	}

	/**
	 * @return the address
	 */
	
	public List<Address> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */

	public void setAddress(List<Address> address) {
		this.address = address;
	}
}