package com.nb.gnome.entities;
import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Nibbles and Bytes
 * @version 1.0
 * 
 *          This class is for the suppliers used by NB Gardens business and uses
 *          variables to model the data needed for the system.
 **/

@Entity
@Table (name = "Returns")
public class Returns {
	//attributes
	@Id
	@OneToOne
	@JoinColumn(name = "FKsalesOrderDetails")
	private SalesOrderDetails salesOrderDetails;
	
	@Column (name = "date", 
			nullable = false)
	@GeneratedValue(
			strategy = GenerationType.IDENTITY)
	private Date date;
	
	@Column (name = "reason", 
			nullable = false, length = 8000)
	@NotNull
	@Size (min = 2, max = 8000)
	private String reason;
	
	//constructors	
	public Returns(){
		
	}

	/**
	 * Method to return an Instance of a Sales Order Details containing the returned product
	 * @return SalesOrderDetails Object
	 * */
	public SalesOrderDetails getSalesOrderDetails() {
		return salesOrderDetails;
	}

	/**
	 * Method to set an Instance of a Sales Order Details containing the returned product
	 * @param salesOrderDetails the salesOrderDetails to set
	 */
	public void setSalesOrderDetails(SalesOrderDetails salesOrderDetails) {
		this.salesOrderDetails = salesOrderDetails;
	}

	/**
	 * Method to return the date of the returned product
	 * @return the date to return
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Method to set the date of the returned product
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Method to return the reason given for the returned product
	 * @return reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * Method to set the reason given for the returned product
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

}
