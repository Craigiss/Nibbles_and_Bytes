package com.nb.gnome.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Nibbles and Bytes
 * @version 1.0
 * 
 *
 */
@Entity 
@Table (name = "PurchaseOrder")

public class PurchaseOrder {
	@Id
	@Column (name = "id")
	@GeneratedValue (
	strategy = GenerationType.IDENTITY	)
	private int id;
	
	@Column (name = "date", nullable = false)
	@NotNull
	private Date date;
	
	@Column (name = "status", nullable = false, length = 60 )
	@NotNull 
	@Size (min = 2, max = 60)
	private String status;
	
	@ManyToOne 
	@JoinColumn(name = "FKSupplierid", nullable = false)
	private Supplier supplier;
	
	/**
	 * @return the supplierid
	 */
	public Supplier getSupplierid() {
		return supplier;
	}

	/**
	 * @param supplier the supplierid to set
	 */
	public void setSupplierid(Supplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * @return the addresses
	 */
	public List<PurchaseOrderDetails> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<PurchaseOrderDetails> addresses) {
		this.addresses = addresses;
	}

	@OneToMany(targetEntity=PurchaseOrderDetails.class)
	private List<PurchaseOrderDetails> addresses;
	
	/**
	 * Default Constructor
	 */
	
	public PurchaseOrder() {

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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	
	public Supplier getSupplier(Supplier s){
		return supplier;
	}
	
	public void setSupplier(Supplier s){
		this.supplier = s;
	}

}
