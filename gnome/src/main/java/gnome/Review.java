package gnome;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * @author Nibbles and Bytes
 * @version 1.0
 * 
 *          This class is for the suppliers used by NB Gardens business and uses
 *          variables to model the data needed for the system.
 **/

public class Review {
	
	@Id
	@Column (name = "id")
	@GeneratedValue (
	strategy = GenerationType.IDENTITY	)
	private int id;
	
	@Column (name = "date", nullable = false)
	@NotNull
	private Date date;
	
	@Column (name = "reviewText", nullable = true, length = 255 )
	@Null 
	@Size (min = 2, max = 255)
	private String reviewText;
	
	@Column (name = "rating", nullable = true)
	@Null
	@Size (min = 0, max = 5)
	private int rating;
	
	@ManyToOne 
	@JoinColumn(name = "FKProductid", nullable = false)
	private int Productid;
	
	@ManyToOne 
	@JoinColumn(name = "FKCustomerid", nullable = false)
	private int Customerid;
	
	/**
	 * Default Constructor
	 */

	public Review() {

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
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 
	 * @return reviewText
	 */
	public String getReviewText() {
		return reviewText;
	}

	/**
	 * 
	 * @param reviewText the reviewText to set
	 */
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	/**
	 * 
	 * @return rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * 
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

}
