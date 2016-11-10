package com.nb.gnome.managers.offline;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.ISAccount;
import com.nb.gnome.managers.ISAccountRepository;

import gnome.InitialData;
@Default
@Stateless
public class ISAccountRepositoryOffline implements ISAccountRepository{
	
	@Inject
	private InitialData initialData;

	@Override
	public void persistISAccount(ISAccount isa) {
		initialData.addISAccount(isa);		
	}
	
	@Override
	public void persistISAccountAdmin(ISAccount isa) {
		initialData.addISAccount(isa);
		
	}

	@Override
	public ISAccount findISAccountByEmail(String email) {
		ISAccount is = new ISAccount();
		for (ISAccount isa : initialData.getISAccounts()){
			if (isa.getEmail().equals(email))
			{
				is = isa;
			}
		}
		return is;
	}
	
	@Override
	public String findSaltByEmail(String email) {
		String salt="";
		for (ISAccount isa : initialData.getISAccounts()){
			if (isa.getEmail().equals(email))
			{
				salt = isa.getSalt();
			}
		}
		return salt;
	}

	@Override
	public List<ISAccount> findAll(){
		List<ISAccount> accounts = new ArrayList<ISAccount>();
		for (ISAccount a : initialData.getISAccounts())
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
	
	//Runs multiple password hashes with salt combined  (this method is for persisting new accounts)
			@Override
			public String seasonAndCook(String email, String npassword, String nsalt) throws Exception{
				// Hash password
				String password = npassword;
				
				String hashedPassword = hashSha256(password);
				

				String salt = nsalt;
				
			
				String saltedPassword = addSeasoning(hashedPassword, salt);
				
				// Hashing password + salt
				String finalPassword = hashSha256(saltedPassword);
				
				for(int hashCounter = 0; hashCounter < 5000; hashCounter++){
					finalPassword = hashSha256(finalPassword);
				}

				return finalPassword;
				
						
			}
	
	

	

}
