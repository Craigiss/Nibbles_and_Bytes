package com.nb.gnome.service;

import java.security.MessageDigest;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.Customer;
import com.nb.gnome.managers.CustomerRepository;

@Stateless
public class LoginService {
	@Inject
	CustomerRepository customerManager;
	
	public boolean validateDetails(String email, String pass) throws Exception{
		 
		if (customerManager.getCustomerByEmail(email) == null){
			return false;
		}
		
		String hashedPassword = getHashFromPassword(email, pass);				// Hashes the held password to check the database password (which will also be hashed)
		if(customerManager.getCustomerByEmail(email).getPassword().matches(hashedPassword)){
			return true; 
		}
		
		
		return false;
		
	}
	public int getID(String email){
		Customer customer = customerManager.getCustomerByEmail(email);
		int id = customer.getId();
		return id;
	}
	public String getName(String email){
		
		Customer customer = customerManager.getCustomerByEmail(email);
		String name = customer.getFirstName();
		return name;
	}
	
	
	
	// *** Hashing Algorithms start
	
	
	public String getHashFromPassword(String email, String password) throws Exception{  // This method gets the customer,  
		Customer c = customerManager.getCustomerByEmail(email);							// then hashes the provided input using the salt in customer account linked with the email, 
																						// checking if this is equal to the stored password (which was hashed at account creation).
		String hashedPassword = hashSha256(password);
		String salt = c.getSalt(); 
		String saltedPassword = addSeasoning(hashedPassword, salt);
		
		String finalPassword = hashSha256(saltedPassword);
		for(int hashCounter = 0; hashCounter < 5000; hashCounter++){			//Repeats the hash multiple times for security.
			finalPassword = hashSha256(finalPassword);
		}
				
				System.out.println(finalPassword);
		return(finalPassword);
	}
	
	static String hashSha256(String toHash) throws Exception{ // This method is used to hash a string using the SHA 512 algorithm
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
	     md.update(toHash.getBytes());
	     
	     byte byteData[] = md.digest();
	     
	     StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1)); // Output from this function is in hexadecimal format
	        }

		return sb.toString();
	}

	
	static String addSeasoning(String password, String salt) { // This method is used to add the salt to the password
		
		int saltLength = salt.length();
		
		String saltp1 = salt.substring(0, (saltLength/2));
		String saltp2 = salt.substring((saltLength/2), saltLength);
		
		String seasonedPassword = saltp1.concat(password);
		seasonedPassword = seasonedPassword.concat(saltp2);
	        

		return seasonedPassword;
	}
	
	// *** Hashing Algorithms finish
}
