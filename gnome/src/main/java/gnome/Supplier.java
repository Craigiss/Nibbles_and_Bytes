package gnome;

/**
 * @author Nibbles and Bytes
 * @version 1.0
 * 
 *          This class is for the suppliers used by NB Gardens business and uses
 *          variables to model the data needed for the system.
 **/

public class Supplier {

	/* Variables of the supplier class */
	private int id;
	private String company;
	private String name;
	private String phone;
	private String email;

	/* Getters and Setters */

	/**
	 * Gets Id of supplier
	 * 
	 * @return id of supplier
	 **/
	public int getId() {
		return id;
	}
	

	/**
	 * Sets Id of supplier
	 * 
	 * @param id - sets id of supplier
	 **/
	public void setId(int id) {
		this.id = id;
	}
	

	/**
	 * Gets company of supplier
	 * 
	 * @return company of supplier
	 **/
	public String getCompany() {
		return company;
	}
	

	/**
	 * Sets company of supplier
	 * 
	 * @param company - sets company of supplier
	 **/
	public void setCompany(String company) {
		this.company = company;
	}
	

	/**
	 * Gets name of contact at the supplier
	 * 
	 * @return name of contact at the supplier
	 **/
	public String getName() {
		return name;
	}
	

	/**
	 * Sets name of contact at the supplier
	 * 
	 * @param name - sets name of contact at the supplier
	 **/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets phone number of contact at the supplier
	 * 
	 * @return phone number of contact at the supplier
	 **/
	public String getPhone() {
		return phone;
	}
	

	/**
	 * Sets phone number of contact at the supplier
	 * 
	 * @param phone - sets phone number of contact at the supplier
	 **/
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Gets email address of contact at the supplier
	 * 
	 * @return email address of contact at the supplier
	 **/
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets email address of contact at the supplier
	 * 
	 * @param email - sets email address of contact at the supplier
	 **/
	public void setEmail(String email) {
		this.email = email;
	}

}
