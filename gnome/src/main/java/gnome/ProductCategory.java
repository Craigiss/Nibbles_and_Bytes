package gnome;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**Author Nibbles and Bytes - Cameron 
 * Version 1
 * Class holds information on a product's category.
 */

public class ProductCategory {
	
	@Id
	@Column(name = "categoryID")
	@ManyToOne
	@JoinColumn(name="FKcategoryID",
	nullable = false)
	@NotNull
	int categoryID;
	
	@Id
	@Column(name = "productID")
	@ManyToOne
	@JoinColumn(name="FKproductID",
	nullable = false)
	@NotNull
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
