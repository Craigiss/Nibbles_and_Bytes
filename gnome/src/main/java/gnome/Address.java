package gnome;

/**
 * @author Nibbles and Bytes
 * @version 1.0.0
 */

public class Address {

	private int id;
	private String line1;
	private String line2;
	private String town;
	private String county;
	private String postcode;

	/**
	 * Default constructor taking no arguments
	 */
	public Address() {

	}

	/**
	 * Method to return the ID of the address instance
	 * @return Returns ID as an int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method to set the ID of the address instance
	 * @param id Input to set the ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Method to get line 1 of the address instance
	 * @return Returns line 1 of the address as a string
	 */
	public String getLine1() {
		return line1;
	}

	/**
	 * Method to set line 1 of the address instance
	 * @param line1 Input to set line 1 of the address
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}

	/**
	 * Method to get line 2 of the address instance
	 * @return Returns line 2 of the address as a string
	 */
	public String getLine2() {
		return line2;
	}

	/**
	 * Method to set line 2 of the address instance
	 * @param line2 Input to set line 2 of the address
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	/**
	 * Method to get the town of the address instance
	 * @return Returns the town of the address as a string
	 */
	public String getTown() {
		return town;
	}

	/**
	 * Method to set the town of the address instance
	 * @param town Input to set the town of the address
	 */
	public void setTown(String town) {
		this.town = town;
	}

	/**
	 * Method to get the county of the address instance
	 * @return Returns the county of the address as a string
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * Method to set the county of the address instance
	 * @param county Input to set the county of the address
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * Method to get the post code of the address instance
	 * @return Returns the post code of the address as a string
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * Method to set the post code of the address instance
	 * @param postcode Input to set the post code of the address
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}
