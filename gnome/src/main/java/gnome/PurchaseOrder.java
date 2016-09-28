package gnome;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;





/**
 * 
 * @author Nibbles and Bytes Version: 1 Class hold information on purchase
 *         orders to order stock
 */
@Entity 
@Table (name = "PurchaseOrder")
public class PurchaseOrder {
	@Id
	@Column (name = "id")
	@GeneratedValue (
	strategy = GenerationType.IDENTITY	)
	private int id;
	
	@Column (name = "date", nullable = false)
	@NotNull
	private Date date;
	
	@Column (name = "status", nullable = false, length = 60 )
	@NotNull 
	@Size (min = 2, max = 60)
	private String status;
	
	@ManyToOne 
	@JoinColumn(name = "FKSupplierid", nullable = false)
	private int Supplierid;
	
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
