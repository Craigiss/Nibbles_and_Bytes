package com.nb.gnome.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;



/**
 * @author Nibbles and Bytes
 * @version 1.0
 * 
 *          This class is for the suppliers used by NB Gardens business and uses
 *          variables to model the data needed for the system.
 **/


@Entity
@Table (name = "ProductCategory")
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryID")
//	@ManyToOne
//	@JoinColumn(name="FKcategoryID",
//	nullable = false)
//	@NotNull
	int categoryID;
//	
//	@Id
	@Column(name = "productID")
//	@ManyToOne
//	@JoinColumn(name="FKproductID",
//	nullable = false)
//	@NotNull
	int productID;
	
	
	/**
	 * @return the categoryID
	 */
	public int getCategoryID() {
		return categoryID;
	}
	/**
	 * @param categoryID the categoryID to set
	 */
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}
	/**
	 * @param productID the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}
}
