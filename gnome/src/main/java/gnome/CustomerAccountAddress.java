package gnome;

import java.util.List;

import javax.persistence.*;

public class CustomerAccountAddress {
	@OneToMany
	@JoinColumn(name="username_fk", nullable = false)
	private CustomerAccount username;
	
	@ManyToOne
	@JoinColumn(name="address_fk", nullable = false)
	private List<Address> address;

	/**
	 * @return the username
	 */
	public CustomerAccount getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(CustomerAccount username) {
		this.username = username;
	}

	/**
	 * @return the address
	 */
	public List<Address> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(List<Address> address) {
		this.address = address;
	}

}
