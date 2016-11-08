package com.nb.gnome.service;


import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.Customer;
import com.nb.gnome.managers.CustomerRepository;
import com.nb.gnome.managers.AddressRepository;

import gnome.InitialData;

import com.nb.gnome.entities.Address;

@Stateless
public class CreateAccountService {
	@Inject 
	CustomerRepository customerManager; 
	@Inject 
	InitialData initialData;
	@Inject
	AddressRepository addressManager; 
	
	public void newUser(String firstName, String surname, String email, String firstLine,String secondLine, String town, String county, String postcode, String password) throws Exception{
		//Hashing and stuff, split the name to first and last 
		
		Customer c = new Customer();
		Address a = new Address();
		List<Address> addresses = new ArrayList<Address>();
		//a.setId(addressManager.getAddresses().size()+1);
		a.setLine1(firstLine);	
		a.setLine2(secondLine);   // Does the addresses stuff
		a.setTown(town);
		a.setCounty(county);
		a.setPostcode(postcode);
		addresses.add(a);
		c.setAddresses(addresses);
		
		c.setFirstName(firstName);					// Does the customer credentials.
		c.setSurname(surname);
		c.setEmail(email);
		//c.setId(initialData.getCustomerAccounts().size() + 1);
		c.setStatus("active");
		
		
		// Hashing password stuff
		
		String salt = randomStringGenerator();
		c.setSalt(salt);
		String hashedPassword = hashPassword(password, salt);
		c.setPassword(hashedPassword);


		customerManager.persistCustomer(c);	
	}
	
	public String hashPassword(String password, String salt) throws Exception{  // WARNING *** This MUST be kept the same as LoginService.getHashFromPassword() ***
		String hashedPassword = LoginService.hashSha256(password);				// This method sets the salt for the first time & irreversibly hashes the password using it.
		
		String saltedPassword = LoginService.addSeasoning(hashedPassword, salt);
		
		String finalPassword = LoginService.hashSha256(saltedPassword);
		for(int hashCounter = 0; hashCounter < 5000; hashCounter++){			//Repeats the hash multiple times for security.
			finalPassword = LoginService.hashSha256(finalPassword);
		}	
		return(finalPassword);
	}
	
	private String randomStringGenerator(){										// Used to randomly generate the salt value in custo
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}



}
