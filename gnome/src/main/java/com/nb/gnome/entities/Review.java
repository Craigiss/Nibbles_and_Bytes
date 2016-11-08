package com.nb.gnome.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * @author Nibbles and Bytes
 * @version 1.0
 * 
 *          This class is for the suppliers used by NB Gardens business and uses
 *          variables to model the data needed for the system.
 **/


@Entity
@Table (name = "Review")
public class Review {
	
	@Id
	@Column (name = "id")
	@GeneratedValue (
	strategy = GenerationType.IDENTITY	)
	private int id;
	
	@Column (name = "date", nullable = false)
	@NotNull
	private String date;
	
	@Column (name = "reviewText",  length = 255 )
	@Size (min = 2, max = 255)
	private String reviewText;
	
	public void setCustomerid(Customer customerid) {
		Customerid = customerid;
	}

	@Column (name = "rating")
	private int rating;
	
	@Column (name = "name", nullable = false)
	@NotNull
	private String name;
	
	@ManyToOne 
	@JoinColumn(name = "FKProductid", nullable = false)
	private Product Product_id;
	
	@ManyToOne 
	@JoinColumn(name = "FKCustomerid", nullable = false)
	private Customer Customerid;
	
	//this will break if we change it to Product
	private int Productid;
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	/**
	 * Default Constructor
	 */

	public Review() {

	}

	public int getId() {
		return id;
	}
	public  void setProductID(int id){
		this.Productid = id;
	}
	public int getProductid() {
		return Productid;
	}

	public int getCustomerid() {
		return Customerid.getId();
	}

	/**
	 * 
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	public Product getProduct_id() {
		return Product_id;
	}

	public void setProduct_id(Product product_id) {
		Product_id = product_id;
	}

	/**
	 * 
	 * @return reviewText
	 */
	public String getReviewText() {
		return reviewText;
	}

	/**
	 * 
	 * @param reviewText the reviewText to set
	 */
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	/**
	 * 
	 * @return rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * 
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
