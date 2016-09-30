package com.nb.gnome.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Nibbles and Bytes 
 * Version 1.0
 * Class InventoryStaffAccount holds the information required for the inventory staff to log into NB Gardens' order system
 *
 */

@Entity
@Table (name = "InventoryStaffAccount")
public class InventoryStaffAccount {
	//attributes
	@Id
	@Column (name = "email",
			nullable = false, length = 255)
	@NotNull
	@Size (min = 2, max = 255)
	private String email;
	@Column (name = "password",
			nullable = false, length = 255)
	@NotNull
	@Size (min = 2, max = 255)
	private String password;
	@Column (name = "name",
			nullable = false, length = 255)
	@NotNull
	@Size (min = 2, max = 255)
	private String name;
	
	//constructors
	/**
	 * Method to get the inventory staff email address 
	 * @return inventory staff email address
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Method to set the inventory staff email address 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Method to get the inventory staff password 
	 * @return inventory staff password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Method to set the inventory staff password 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Method to get the inventory staff name 
	 * @return inventory staff name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Method to set the inventory staff name 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
