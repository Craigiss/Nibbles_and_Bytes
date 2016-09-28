package gnome;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author Nibbles And Bytes
 * @version 1.0
 * Class holds information on a customer sorted within the database
 * */

@Entity
@Table (name = "CustomerAccount")
public class CustomerAccount {
	
	@Id
	@Column (name = "email", nullable = false, length = 255)
	@NotNull
	@Size(min = 2, max = 225)
	private String email;
	
	@Column (name = "password", nullable = false, length = 255 )
	@NotNull
	@Size(min = 2, max = 225)
	private String password;
	
	@Column (name = "firstName", nullable = false, length = 255 )
	@NotNull
	@Size(min = 2, max = 225)
	private String firstName;
	
	@Column (name = "surname", nullable = false, length = 255 )
	@NotNull
	@Size(min = 2, max = 225)
	private String surname;
	
	@Column (name = "title", nullable = false, length = 5 )
	@NotNull
	@Size(min = 2, max = 5)
	private String title;
	
	@Column (name = "phoneNumber", nullable = false, length = 11 )
	@NotNull
	@Size(min = 2, max = 11)
	private int phoneNumber;
	
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
	 * @param String email - email address of customer
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
	 * @param String password - password for customer
	 * */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets first name of a customer
	 * @param String firstname - firstname of customer
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
	 * @param String surname - surname of customer
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
	 * @param String title - title of customer
	 * */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns phone number of a customer
	 * @return phone number
	 * */
	public int getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets phone number of a customer
	 * @param String phoneNumber - phone number of a customer
	 * */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
