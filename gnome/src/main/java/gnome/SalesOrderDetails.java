package gnome;

/**
 * @author Nibbles and Bytes
 * @version 1.0
 * 
 *          This class is for the sales order details used by NB Gardens business for each sales order and uses
 *          variables to model the data needed for the system.
 **/

public class SalesOrderDetails {
	
	/* Variables of the supplier class */
	private int productId;
	private int quantity;
	private int salesOrderId;
	
	/* Getters and Setters */
	
	/**
	 * Gets Id of product in an order
	 * 
	 * @return id of product
	 **/
	public int getProductId() {
		return productId;
	}
	
	/**
	 * Sets Id of product in an order
	 * 
	 * @param int - sets id of product in an order
	 **/
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	/**
	 * Gets quantity of a product in an order
	 * 
	 * @return quantity of product
	 **/
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Sets quantity of each product in an order
	 * 
	 * @param int - sets quantity of product in an order
	 **/
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Gets Id of the sales order
	 * 
	 * @return id of sales order
	 **/
	public int getSalesOrderId() {
		return salesOrderId;
	}
	
	/**
	 * Sets id of the order id
	 * 
	 * @param int - sets id of the order id
	 **/
	public void setSalesOrderId(int salesOrderId) {
		this.salesOrderId = salesOrderId;
	}
	
	
	
}
