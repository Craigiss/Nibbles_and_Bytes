package gnome;
import java.sql.Date;

/**
 * @Author Nibbles And Bytes
 * @version 1.0
 * Class holds information on products that have been returned
 * */

public class Returns {
	
	private SalesOrderDetails salesOrderDetails;
	private Date date;
	private String reason;
	
	public Returns(){
		
	}

	/**
	 * Returns Instance of a Sales Order Details containting the product that is to be returned
	 * @return SalesOrderDetails Object
	 * */
	public SalesOrderDetails getSalesOrderDetails() {
		return salesOrderDetails;
	}

	public void setSalesOrderDetails(SalesOrderDetails salesOrderDetails) {
		this.salesOrderDetails = salesOrderDetails;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
