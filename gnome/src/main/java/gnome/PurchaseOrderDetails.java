package gnome;

/**
 * @author Nibbles and Bytes
 * @version 1.0.0
 */

public class PurchaseOrderDetails {
	
	private int quantity;
	private Product product;
	private PurchaseOrder purchaseOrder;
	
	/**
	 * Default constructor taking no arguments
	 */
	public PurchaseOrderDetails(){
		
	}

	/**
	 * Method to return quantity of products ordered within the purchase order detail instance
	 * @return Returns quantity of products ordered within the purchase order detail instance
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Method to set the quantity of products ordered for the purchase order detail instance
	 * @param quantity Input for quantity of products ordered
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Method to get the product ordered within the purchase order detail instance
	 * @return Returns product object ordered within the purchase order detail instance
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Method to set the product ordered within the purchase order detail instance
	 * @param product Input is the product object to be linked with the instance
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Method to get the purchase order this purchase order detail is linked to
	 * @return Returns purchase order object
	 */
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	/**
	 * Method to set the purchase order this instance is linked to
	 * @param purchaseOrder Input is the purchase order this instance should be linked to
	 */
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	


}
