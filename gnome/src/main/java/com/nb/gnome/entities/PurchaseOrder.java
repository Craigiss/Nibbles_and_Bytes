package com.nb.gnome.entities;

import java.util.Date;
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
	private int Supplierid;
	
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

	

}
