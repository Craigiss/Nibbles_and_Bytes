package com.nb.gnome.managers;
import java.util.List;
import com.nb.gnome.entities.*;
import com.nb.gnome.entities.Customer;


public interface CustomerRepository {

	//Create
	public void persistCustomer(Customer c);
	
	//Read
	public Customer getCustomerById(long id);
	public Customer getCustomerByEmail(String email);
	
	//Update
	public void changeFirstName(String name, int id);
	public void changeSurname(String surname, int id);
	public void changePassword(String password, int id);
	public void changeEmailAddress(String email, int id);
	
	//Delete
	public void changecustomerStatus(int id);

	void changecustomerAddress(List<Address> address, int id);
	
}
