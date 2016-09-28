package gnome;
import java.sql.Date;

/**
 * @Author Nibbles And Bytes
 * @version 1.0
 * Class holds information on a sales order sorted within the database
 * */

public class SalesOrder {

	private int id;
	private Date date;
	private CustomerAccount customer;
	private String status;

	public SalesOrder(){	
	}

	/**
	 * Returns order id of a customer order
	 * @return order id
	 * */
	public int getId() {
		return id;
	}

	/**
	 * Sets order id of a customer order
	 * @param Int id - email address of customer
	 * */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns Date that a customer order was placed
	 * @return Date
	 * */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets date of a customer order
	 * @param String Date - email address of customer
	 * */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Returns an instance of a customer that placed the order
	 * @return Customer object
	 * */
	public CustomerAccount getCustomer() {
		return customer;
	}

	/**
	 * Assigns a customer object to an order
	 * @param Customer Object
	 * */
	public void setCustomer(CustomerAccount customer) {
		this.customer = customer;
	}

	/**
	 * Returns  status of a customer order
	 * @return status
	 * */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status of a customer order
	 * @param String status
	 * */
	public void setStatus(String status) {
		this.status = status;
	}

}
