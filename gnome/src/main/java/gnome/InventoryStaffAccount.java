package gnome;

/**
 * 
 * @author Nibbles and Bytes - Craig
 * Version 1
 * 
 * Class InventoryStaffAccount holds the information required for the inventory staff to log into NB Gardens' order system
 *
 */

public class InventoryStaffAccount {
	//attributes
	
	private String email;
	private String password;
	private String name;
	
	//constructors
	/**
	 * Method to get the inventory staff email address 
	 * @return inventory staff email address
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Method to set the inventory staff email address 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Method to get the inventory staff password 
	 * @return inventory staff password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Method to set the inventory staff password 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Method to get the inventory staff name 
	 * @return inventory staff name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Method to set the inventory staff name 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
