package com.nb.gnome.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @author Nibbles and Bytes
 * @version 1.0
 * 
 *          This class is for the sales order details used by NB Gardens business for each sales order and uses
 *          variables to model the data needed for the system.
 **/

@Entity
@Table (name = "SalesOrderDetails")
public class SalesOrderDetails {
	
	/* Variables of the supplier class */
	@Id
	@Column  (name = "Id")
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private long id;	


	@Column  (name = "FKproductId", nullable = false)
	private long FKproductId;
	
	@Column (name = "quantity",	nullable = false)
	private int quantity;
	

	@Column  (name = "FKsalesOrderId", nullable = false)
	private long FKsalesOrderId;
	
	/* Getters and Setters */
	
	/**
	 * Gets Id of sales order details
	 * 
	 * @return id of sales order details
	 **/
	public long getId() {
		return id;
	}
	
	/**
	 * Sets Id of sales order details
	 * 
	 * @param id - sets id of sales order details
	 **/
//	public void setId(int id) {
//		this.id = id;
//	}
	
	/**
	 * Gets Id of product in an order
	 * 
	 * @return id of product
	 **/
	public long getFKProductId() {
		return FKproductId;
	}
	
	/**
	 * Sets Id of product in an order
	 * 
	 * @param FKproductId - sets id of product in an order
	 **/
	public void setProductId(int FKproductId) {
		this.FKproductId = FKproductId;
	}
	
	/**
	 * Gets quantity of a product in an order
	 * 
	 * @return quantity of product
	 **/
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Sets quantity of each product in an order
	 * 
	 * @param quantity - sets quantity of product in an order
	 **/
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Gets Id of the sales order
	 * 
	 * @return id of sales order
	 **/
	public long getFKSalesOrderId() {
		return FKsalesOrderId;
	}
	
	/**
	 * Sets id of the order id
	 * 
	 * @param FKsalesOrderId - sets id of the order id
	 **/
	public void setFKSalesOrderId(long FKsalesOrderId) {
		this.FKsalesOrderId = FKsalesOrderId;
	}
	
	
	
}
