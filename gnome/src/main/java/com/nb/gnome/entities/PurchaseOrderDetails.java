package com.nb.gnome.entities;

import javax.persistence.*;

/**
 * @author Nibbles and Bytes
 * @version 1.0
 * 
 *          This class is for the suppliers used by NB Gardens business and uses
 *          variables to model the data needed for the system.
 **/

@Entity
@Table (name = "PurchaseOrderDetails")
public class PurchaseOrderDetails {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Product product;
	
	@Column (name = "quantity", nullable = false)
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="po_id")
	private PurchaseOrder po;
	
	/**
	 * Default constructor taking no arguments
	 */
	public PurchaseOrderDetails(){
		
	}

	/**
	 * Method to return quantity of products ordered within the purchase order detail instance
	 * @return Returns quantity of products ordered within the purchase order detail instance
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Method to set the quantity of products ordered for the purchase order detail instance
	 * @param quantity Input for quantity of products ordered
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the po
	 */
	public PurchaseOrder getPo() {
		return po;
	}

	/**
	 * @param po the po to set
	 */
	public void setPo(PurchaseOrder po) {
		this.po = po;
	}

	
}
