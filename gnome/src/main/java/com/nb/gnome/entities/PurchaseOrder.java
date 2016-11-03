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
	private Supplier supplier;
	
	@OneToMany(mappedBy ="po")
	private List<PurchaseOrderDetails> lines;
	
	@Column(name = "deleted")
	private boolean deleted;

	/**
	 * Default Constructor
	 */
	
	public PurchaseOrder() {
		deleted = false;
	}
	
	public PurchaseOrder(int id, Date date, String status, List<PurchaseOrderDetails> list){
		this.id=id;
		this.date=date;
		this.status=status;
		this.lines = list;
	}
	
	
	/**
	 * @return the addresses
	 */
	public List<PurchaseOrderDetails> getLines() {
		return lines;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setLines(List<PurchaseOrderDetails> lines) {
		this.lines = lines;
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
	
	public Supplier getSupplier(){
		return supplier;
	}
	
	public void setSupplier(Supplier s){
		this.supplier = s;
	}

	public String calculateTotal(){
		int pounds = 0;
		int pence = 0;
		for(PurchaseOrderDetails d : lines){
			pounds += (int) (d.getProduct().getPrice() / 1);
			pence += (int) ((d.getProduct().getPrice()) * 100) % 100;
			if(pence >= 100){
				pounds++;
				pence =- 100;
			}
		}
		return "£" + pounds + "." + pence;
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
	
	

}
