package com.nb.gnome.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @author Nibbles and Bytes
 * @version 1.0
 * 
 *          This class is for the suppliers used by NB Gardens business and uses
 *          variables to model the data needed for the system.
 **/

@Entity
@Table (name = "Supplier")
public class Supplier {

	/* Variables of the supplier class */
	@Id
	@Column  (name = "supplierId")
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	
	@Column (name = "company",	nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)	
	private String company;
	
	@Column (name = "name",	nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String name;
	
	@Column (name = "phone", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String phone;
	
	@Column (name = "email", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String email;
	
	@Column (name = "description", length = 500)
	@Size (min = 0, max = 500)
	private String description;
	
	@Column(name = "deleted")
	private boolean deleted;
	
	@OneToMany(mappedBy ="supplier")
	private List<Product> products;
	
	@OneToOne
	private Address address;
	
	
	public Supplier(){
		products = new ArrayList<Product>();
	}
	
	public Supplier(String company, String name, String phone, String email, String description, Address address){
		this.company = company;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.description = description;
		deleted = false;
		this.address = address;
		products = new ArrayList<Product>();
	}

	/* Getters and Setters */

	/**
	 * Gets Id of supplier
	 * 
	 * @return id of supplier
	 **/
	public int getId() {
		return id;
	}
	

	/**
	 * Sets Id of supplier
	 * 
	 * @param id - sets id of supplier
	 **/
	public void setId(int id) {
		this.id = id;
	}
	

	/**
	 * Gets company of supplier
	 * 
	 * @return company of supplier
	 **/
	public String getCompany() {
		return company;
	}
	

	/**
	 * Sets company of supplier
	 * 
	 * @param company - sets company of supplier
	 **/
	public void setCompany(String company) {
		this.company = company;
	}
	

	/**
	 * Gets name of contact at the supplier
	 * 
	 * @return name of contact at the supplier
	 **/
	public String getName() {
		return name;
	}
	

	/**
	 * Sets name of contact at the supplier
	 * 
	 * @param name - sets name of contact at the supplier
	 **/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets phone number of contact at the supplier
	 * 
	 * @return phone number of contact at the supplier
	 **/
	public String getPhone() {
		return phone;
	}
	

	/**
	 * Sets phone number of contact at the supplier
	 * 
	 * @param phone - sets phone number of contact at the supplier
	 **/
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Gets email address of contact at the supplier
	 * 
	 * @return email address of contact at the supplier
	 **/
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets email address of contact at the supplier
	 * 
	 * @param email - sets email address of contact at the supplier
	 **/
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

}
