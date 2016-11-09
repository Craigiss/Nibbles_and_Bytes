package com.nb.gnome.entities;
import java.util.List;

import javax.persistence.*;



/**
 * @author Nibbles and Bytes
 * @version 1.0
 * 
 *          This class is for the suppliers used by NB Gardens business and uses
 *          variables to model the data needed for the system.
 **/

@Entity
@Table (name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productID")
	int productID;
	
	@Column(name = "productName")
	String productName;
	
	@Column(name = "description", length = 255)
	String description;
	
	@Column(name = "image")
	String imgPath;
	
	@Column(name = "price")
	double price;
	
	@Column (name = "rating")
	int rating; 
	
	@Column(name = "stockLevel")
	int stockLevel;
	
	@Column
	int supplierID;
	
	@OneToMany(mappedBy = "Product_id")
	private List<Review> reviews;
	
	@ManyToOne
	@JoinColumn(name="category")
	private Category category;
	
	int Quantity;
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return Quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	/**
	 * @return the imgPath
	 */
	public String getImgPath() {
		return imgPath;
	}
	/**
	 * @param imgPath the imgPath to set
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@OneToMany(targetEntity=ProductCategory.class)
	private List<ProductCategory> productCategories;

	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}
	/**
	 * @param productID the productID to set 
	 */
//	public void setProductID(int productID) {
//		this.productID = productID;
//	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the stockLevel
	 */
	public int getStockLevel() {
		return stockLevel;
	}
	/**
	 * @param stockLevel the stockLevel to set
	 */
	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}
	/**
	 * @return the supplierID
	 */
	public int getSupplierID() {
		return supplierID;
	}
	/**
	 * @param supplierID the supplierID to set
	 */
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	/**
	 * @return the categories
	 */
	public List<ProductCategory> getProductCategories() {
		return productCategories;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setProductID(int i) {
		this.productID =i;
		
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	

}
