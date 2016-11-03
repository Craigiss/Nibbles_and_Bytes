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
	private int productID;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private double price;
	
	@Column(name ="image")
	private String imgPath;
	
	@Column(name = "stockLevel")
	private int stockLevel;
	
	@Column(name = "porousStockLevel")
	private int porousStockLevel;
	
	@Column(name ="deleted")
	private boolean deleted;
	
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;
		
	public Product(){
		
	}
	
	public Product(int id, String name, String description, double price, int stockLevel, int porousStockLevel, Supplier supplier){
		this.productID = id;
		this.productName = name;
		this.description = description;
		this.price = price;
		this.stockLevel= stockLevel;
		this.porousStockLevel= porousStockLevel;
		this.supplier = supplier;
		deleted = false;
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
	
	
	public int getPorousStockLevel() {
		return porousStockLevel;
	}

	public void setPorousStockLevel(int porousStockLevel) {
		this.porousStockLevel = porousStockLevel;
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
	
	public String toString(){
		return getProductName() + " " + getStockLevel();
	}

	/**
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
}
