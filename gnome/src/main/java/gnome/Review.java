package gnome;

import java.util.Date;

/**
 * 
 * @author Nibbles and Bytes - Jacob Version: 1 Class hold information on
 *         reviews placed by customers
 */
public class Review {
	private Date date;
	private String reviewText;
	private int rating;

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
