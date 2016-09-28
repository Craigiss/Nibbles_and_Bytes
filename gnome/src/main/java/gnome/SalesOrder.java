package gnome;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Nibbles and Bytes
 * @version 1.0
 * 
 *          This class is for the suppliers used by NB Gardens business and uses
 *          variables to model the data needed for the system.
 **/


public class SalesOrder {

	@Id
	@Column (name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column (name = "date", nullable = false)
	@NotNull
	private Date date;
	
	@ManyToOne
	@JoinColumn (name = "FKCustomerId", nullable= false)
	private CustomerAccount customer;
	
	@Column (name = "status", nullable = false, length = 255 )
	@NotNull
	@Size(min = 2, max = 225)
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
	 * @param id - email address of customer
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
	 * @param date - email address of customer
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
	 * @param customer the customer to set
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
	 * @param status the status to set
	 * */
	public void setStatus(String status) {
		this.status = status;
	}

}
