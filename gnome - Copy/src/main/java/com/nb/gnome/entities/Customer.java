package com.nb.gnome.entities;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Nibbles And Bytes
 * @version 1.0
 * Class holds information on a customer sorted within the database
 * */

@Entity
@Table (name = "CustomerAccount")
public class Customer {
	
	@Id
	@Column (name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;

	@Column (name = "email", nullable = false, length = 255)
	@NotNull
	@Size(min = 2, max = 225)
	private String email;
	
	@Column (name = "password", nullable = false, length = 255 )
	@NotNull
	@Size(min = 2, max = 225)
	private String password;
	
	@Column (name = "firstName", nullable = false, length = 255 )
	@NotNull
	@Size(min = 2, max = 225)
	private String firstName;
	
	@Column (name = "surname", nullable = false, length = 255 )
	@NotNull
	@Size(min = 2, max = 225)
	private String surname;
	
	@Column (name = "title", nullable = false, length = 5 )
	@NotNull
	@Size(min = 2, max = 5)
	private String title;
	
	@Column (name = "phoneNumber", nullable = false, length = 11 )
	@NotNull
	@Size(min = 2, max = 11)
	private String phoneNumber;
	
	@Column (name = "status", nullable = false, length = 11 )
	@NotNull
	@Size(min = 2, max = 11)
	private String status;

	@ManyToMany(targetEntity=Address.class)
	private List<Address> addresses;
	
	public Customer(){	
	}

	/**
	 * Returns email address of customer
	 * @return emails address
	 * */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets email address of customer
	 * @param email - email address of customer
	 * */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns password customer
	 * @return customer password
	 * */
	public String getPassword() {
		return password;
	}

	
	/**
	 * Sets password of a customer
	 * @param password - password for customer
	 * */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets first name of a customer
	 * @param firstName - firstname of customer
	 * */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns surname of customer
	 * @return customer surname
	 * */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets surname of a customer
	 * @param surname - surname of customer
	 * */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Returns title of customer
	 * @return title
	 * */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets title  of a customer
	 * @param title - title of customer
	 * */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns phone number of a customer
	 * @return phone number
	 * */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets phone number of a customer
	 * @param phoneNumber - phone number of a customer
	 * */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the addresses
	 */
	public List<Address> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
}
