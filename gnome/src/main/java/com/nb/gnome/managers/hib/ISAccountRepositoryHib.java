package com.nb.gnome.managers.hib;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.connection.Connection;
import com.nb.gnome.entities.ISAccount;
import com.nb.gnome.entities.Product;
import com.nb.gnome.managers.ISAccountRepository;


@Alternative
@Stateless
public class ISAccountRepositoryHib implements ISAccountRepository{
	
	@Inject 
	private Connection database;
	
	@Inject 
	private ObjectConverter converter;
	

	@Override
	public void persistISAccount(ISAccount isa){
		database.persistData(isa);	
	}
	
	@Override
	public void persistISAccountAdmin(ISAccount isa) {
		database.persistData(isa);
	}

	@Override
	public ISAccount findISAccountByEmail(String email) {
		ArrayList<ISAccount> accountList = (ArrayList)converter.convertToAccount(database.returnData("ISAccount"));
		ISAccount is = new ISAccount();
		for (ISAccount isa : accountList ){
			if (isa.getEmail().equals(email))
			{
				is = isa;
			}
		}
		return is;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String findSaltByEmail(String email) {
		@SuppressWarnings("rawtypes")
		ArrayList<ISAccount> accountList = (ArrayList)converter.convertToAccount(database.returnData("ISAccount"));
		String salt="";
		for (ISAccount isa : accountList){
			if (isa.getEmail().equals(email))
			{
				salt = isa.getSalt();
			}
		}
		return salt;
	}

	@Override
	public List<ISAccount> findAll(){
		ArrayList<ISAccount> accountList = (ArrayList)converter.convertToAccount(database.returnData("ISAccount"));
		List<ISAccount> accounts = new ArrayList<ISAccount>();
		for (ISAccount a : accountList)
			accounts.add(a);
		return accounts;
	}
	
	@Override
	public void updateISAccountName(ISAccount isa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateISAccountEmail(ISAccount isa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateISAccountPassword(ISAccount isa) {
		// TODO Auto-generated method stub
		
	}
	
	//Hashes the user's password
	@Override
	public String hashSha256(String toHash) throws Exception{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
	     md.update(toHash.getBytes());
	     
	     byte byteData[] = md.digest();
	     
	     StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1)); // Output from this function is in hexadecimal format
	        }

		return sb.toString();
	}
	
	//Adds salt to hashed password
	@Override
	public String addSeasoning(String password, String salt){
		int saltLength = salt.length();
		
		String saltp1 = salt.substring(0, (saltLength/2));
		String saltp2 = salt.substring((saltLength/2), saltLength);
		
		String seasonedPassword = saltp1.concat(password);
		seasonedPassword = seasonedPassword.concat(saltp2);
	        

		return seasonedPassword;
	}
	
	//Runs multiple password hashes with salt combined
	@Override
	public String seasonAndCook(String email, String npassword) throws Exception{
		// Hash password
		String password = npassword;
		
		String hashedPassword = hashSha256(password);
		

		String salt = findSaltByEmail(email);
		
	
		String saltedPassword = addSeasoning(hashedPassword, salt);
		
		// Hashing password + salt
		String finalPassword = hashSha256(saltedPassword);
		
		for(int hashCounter = 0; hashCounter < 5000; hashCounter++){
			finalPassword = hashSha256(finalPassword);
		}

		return finalPassword;
		
				
	}
	
	

	

}
