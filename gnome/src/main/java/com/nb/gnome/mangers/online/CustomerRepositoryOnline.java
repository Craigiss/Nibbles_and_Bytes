package com.nb.gnome.mangers.online;


import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.Customer;
import com.nb.gnome.managers.CustomerRepository;
import com.nb.gnome.managers.hib.ObjectConverter;
import connection.Connection;

@Alternative
@Stateless
public class CustomerRepositoryOnline implements CustomerRepository {

	@Inject
	private Connection connection;

	@Inject
	private ObjectConverter converter;
	
	@Override
	public void persistCustomer(Customer c) {
		connection.persistData(c);
	}

	@Override
	public Customer getCustomerById(long id) {
		Customer cust = new Customer();
		for (Customer c : converter.convertToCustomer(connection.returnData("Customer"))){
			if (c.getId() == id)
			{
				cust = c;
			}
		}
		return cust;
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		for (Customer c : converter.convertToCustomer(connection.returnData("Customer"))){
			if (c.getEmail().equals(email))
				return c;
		}
		return null;
	}

	@Override
	public void changeFirstName(String name, int id) {
		for (Customer c : converter.convertToCustomer(connection.returnData("Customer"))){
			if (c.getId()== id)
			{
				c.setFirstName(name);
			}
		}
		
	}

	@Override
	public void changeSurname(String surname, int id) {
		for (Customer c : converter.convertToCustomer(connection.returnData("Customer"))){
			if (c.getId()== id)
			{
				c.setSurname(surname);
			}
		}		
	}

	@Override
	public void changePassword(String password, int id) {
		for (Customer c : converter.convertToCustomer(connection.returnData("Customer"))){
			if (c.getId()== id)
			{
				c.setPassword(password);
			}
		}		
		
	}

	@Override
	public void changeEmailAddress(String email, int id) {
		for (Customer c : converter.convertToCustomer(connection.returnData("Customer"))){
			if (c.getId()== id)
			{
				c.setEmail(email);
			}
		}			
	}

	@Override
	public void changecustomerStatus(int id) {
		for (Customer c : converter.convertToCustomer(connection.returnData("Customer"))){
			if (c.getId()== id)
			{
				c.setStatus("deactivated");
			}
		}	
		
	}

	@Override
	public void changecustomerAddress(List<Address> addresses, int id) {
		for(Customer c : converter.convertToCustomer(connection.returnData("Customer"))){
			if(c.getId() == id){
				c.setAddresses(addresses);
			}
		}
	}
}
