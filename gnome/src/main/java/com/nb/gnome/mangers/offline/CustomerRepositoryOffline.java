package com.nb.gnome.mangers.offline;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import com.nb.gnome.entities.Customer;
import com.nb.gnome.managers.CustomerRepository;

import gnome.InitialData;
@Default
@Stateless
public class CustomerRepositoryOffline implements CustomerRepository {

	@Inject
	private InitialData initialData;
	
	@Override
	public void persistCustomer(Customer c) {
		initialData.addCustomerAccount(c);	
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer cust = new Customer();
		for (Customer c : initialData.getCustomerAccounts()){
			if (c.getId() == id)
			{
				cust = c;
			}
		}
		return cust;
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		Customer cust = new Customer();
		for (Customer c : initialData.getCustomerAccounts()){
			if (c.getEmail().equals(email))
			{
				cust = c;
			}
		}
		return cust;
	}

	@Override
	public void changeFirstName(String name, int id) {
		for (Customer c : initialData.getCustomerAccounts()){
			if (c.getId()== id)
			{
				c.setFirstName(name);
			}
		}
		
	}

	@Override
	public void changeSurname(String surname, int id) {
		for (Customer c : initialData.getCustomerAccounts()){
			if (c.getId()== id)
			{
				c.setSurname(surname);
			}
		}		
	}

	@Override
	public void changePassword(String password, int id) {
		for (Customer c : initialData.getCustomerAccounts()){
			if (c.getId()== id)
			{
				c.setPassword(password);
			}
		}		
		
	}

	@Override
	public void changeEmailAddress(String email, int id) {
		for (Customer c : initialData.getCustomerAccounts()){
			if (c.getId()== id)
			{
				c.setEmail(email);
			}
		}			
	}

	@Override
	public void changecustomerStatus(int id) {
		for (Customer c : initialData.getCustomerAccounts()){
			if (c.getId()== id)
			{
				c.setStatus("deactivated");
			}
		}	
		
	}

}
