package com.nb.gnome.entities;
import java.util.List;

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
@Table (name = "Product")
public class Product {

	@Id
	@Column(name = "productID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	int productID;
	
	@Column(name = "productName")
	String productName;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "price")
	double price;
	
	@Column(name ="image")
	String imgPath;
	
	@Column(name = "stockLevel")
	int stockLevel;
	
	@Column(name = "supplierID")
	@ManyToOne
	@JoinColumn(name="FKCategoryID",
	nullable = false)
	@NotNull
	int supplierID;
	
	@ManyToMany(targetEntity=Category.class)
	private List<Category> categories;
	
	public Product(){
		
	}
	
	public Product(int id, String name, String description, double price, int stockLevel){
		this.productID = id;
		this.productName = name;
		this.description = description;
		this.price = price;
		this.stockLevel= stockLevel;
		
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
	public List<Category> getCategories() {
		return categories;
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
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	

}
