package gnome;
import java.sql.Date;

/**
 * @Author Nibbles And Bytes
 * @version 1.0
 * Class Returns holds information on products that have been returned
 * */

public class Returns {
	
	private SalesOrderDetails salesOrderDetails;
	private Date date;
	private String reason;
	
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
	 * @param salesOrderDetails
	 */
	public void setSalesOrderDetails(SalesOrderDetails salesOrderDetails) {
		this.salesOrderDetails = salesOrderDetails;
	}

	/**
	 * Method to return the date of the returned product
	 * @return
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Method to set the date of the returned product
	 * @param date
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
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

}
