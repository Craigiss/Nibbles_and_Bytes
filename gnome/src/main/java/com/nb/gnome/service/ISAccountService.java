package com.nb.gnome.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.controllers.IMSUserCredentials;
import com.nb.gnome.entities.ISAccount;
import com.nb.gnome.managers.ISAccountRepository;
import gnome.InitialData;
import java.security.SecureRandom;
import java.math.BigInteger;


@Stateless
public class ISAccountService {
	
	@Inject
	private ISAccountRepository iSAccountManager;
//	@Inject
	//private InitialData initialData;
	@Inject
	private IMSUserCredentials  userCredentials;
	
	private String error;
	private String salt;
	
	

	/**
	 * Method to check that an email address used for an account does/doesn't already exist - CMON TIM!!
	 */
	public boolean accountCheck(String nEmail){
		List <ISAccount> accounts = iSAccountManager.findAll();
		boolean accountValid = false;
		CHECK: for (ISAccount a : accounts){
			if (a.getEmail().equals(nEmail)){
				accountValid = true;
				break CHECK;			}
			else{
				accountValid = false;
			}
		}
		return accountValid;
	}
	
	public ISAccount findISAccountByEmail(String email) {
	ISAccount is = iSAccountManager.findISAccountByEmail(email);
		return is;
	}
	
/*	// Connors code
	public boolean validateDetails(String email, String pass){
		if(iSAccountManager.findISAccountByEmail(email)==null){
			return false;
		}
		if(iSAccountManager.findISAccountByEmail(email).getPassword().matches(pass)){
			return true;
		}
		return false;
	}*/
	
	
	/**
	 * Calls the ISAccount manager method, pooling params together to create a new account object
	 * */
	public void persistISAccount(String nEmail, String nPassword, String nName, String nSalt){
		if (accountCheck(nEmail)){
			ISAccount isaisa = new ISAccount(nEmail, nPassword, nName, nSalt, "user");
			iSAccountManager.persistISAccount(isaisa);
		}else{
			int code=1;
			accountError(1);
		}
	}
	
	public void persistISAccountAdmin(String nEmail, String nPassword, String nName, boolean nAdmin, String nSalt){
		if (accountCheck(nEmail)){
			ISAccount isaisa = new ISAccount(nEmail, nPassword, nName, nAdmin, nSalt, "user" );
			iSAccountManager.persistISAccountAdmin(isaisa);
		}else{
			int code=1;
			accountError(code);
		}
	}
	
	/**
	 * Generates a random String for the purposes of a salt for each user account
	 * @return
	 */
	public String randomStringGenerator(){
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}
	
	public String logInToIms(String nEmail, String nPassword){
		boolean validLogOn= false;
		boolean check = accountCheck(nEmail);
		if(!check){
			int code=3;
			accountError(code);
		}
		else{
			String recordedPassword=iSAccountManager.findISAccountByEmail(nEmail).getPassword();
			if(recordedPassword.equals(nPassword)){
				validLogOn=true;
				userCredentials.setEmail(nEmail);
				userCredentials.setName(iSAccountManager.findISAccountByEmail(nEmail).getName());
			}
			else{
				int code=2;
				accountError(code);
			}
		}
		if(validLogOn==true){
			return "successful";
		}
		else{
			return "imsLogin?faces-redirect=true";
		}
	}
	
	public List<ISAccount> findAll(){
		List<ISAccount> a = iSAccountManager.findAll();
		return a;
	}
	
	public String seasonAndCook(String email, String npassword) throws Exception{
		String password = iSAccountManager.seasonAndCook(email, npassword);
		return password;
	}
	
	public String seasonAndCook(String email, String npassword, String salt) throws Exception{
		salt = randomStringGenerator();
		setSalt(salt);
		String password = iSAccountManager.seasonAndCook(email, npassword, salt );
		return password;
	}
	
	// To be adjusted once page is completed
	private void accountError(int code){
		if(code == 1){
			System.out.println("account already exists");
			setError("account already exists");
		}
		else if(code==2){
			System.out.println("email and password do not match records");
			setError("email and password do not match records");
		}
		else{
			System.out.println("email not recognised");
			setError("email not recognised");
		}
		
				
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	
	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	


}
