package gnome;

/**
 * Nibbles And Bytes
 * @version 1.0
 * Class holds information on a customer sorted within the database
 * */


public class CustomerAccount {
	private String email;
	private String password;
	private String firstName;
	private String surname;
	private String title;
	private String phoneNumber;
	
	public CustomerAccount(){	
	}

	/**
	 * Returns email address of customer
	 * @return emails address
	 * */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets email address of customer
	 * @param email - email address of customer
	 * */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns password customer
	 * @return customer password
	 * */
	public String getPassword() {
		return password;
	}

	
	/**
	 * Sets password of a customer
	 * @param password - password for customer
	 * */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets first name of a customer
	 * @param firstName - firstname of customer
	 * */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns surname of customer
	 * @return customer surname
	 * */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets surname of a customer
	 * @param surname - surname of customer
	 * */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Returns title of customer
	 * @return title
	 * */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets title  of a customer
	 * @param title - title of customer
	 * */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns phone number of a customer
	 * @return phone number
	 * */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets phone number of a customer
	 * @param phoneNumber - phone number of a customer
	 * */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
