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

	

}
