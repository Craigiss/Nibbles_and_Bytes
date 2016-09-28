package gnome;

import java.util.Date;

/**
 * 
 * @author Nibbles and Bytes Version: 1 Class hold information on purchase
 *         orders to order stock
 */
public class PurchaseOrder {
	private int id;
	private Date date;
	private String status;

	/**
	 * Default Constructor
	 */
	public PurchaseOrder() {

	}

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
