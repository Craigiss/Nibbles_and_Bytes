package com.nb.gnome.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.controllers.IMSUserCredentials;
import com.nb.gnome.entities.ISAccount;
import com.nb.gnome.managers.ISAccountRepository;

import gnome.InitialData;

@Stateless

public class ISAccountService {
	
	@Inject
	private ISAccountRepository iSAccountManager;
	@Inject
	private InitialData initialData;
	@Inject
	private IMSUserCredentials  userCredentials;
	
	private String error;
	
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
	public void persistISAccount(String nEmail, String nPassword, String nName){
		if (accountCheck(nEmail)){
			ISAccount isaisa = new ISAccount(nEmail, nPassword, nName);
			iSAccountManager.persistISAccount(isaisa);
		}else{
			int code=1;
			accountError(1);
		}
	}
	
	public void persistISAccountAdmin(String nEmail, String nPassword, String nName, boolean nAdmin){
		if (accountCheck(nEmail)){
			ISAccount isaisa = new ISAccount(nEmail, nPassword, nName, nAdmin);
			iSAccountManager.persistISAccountAdmin(isaisa);
		}else{
			int code=1;
			accountError(code);
		}
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
			return "imsLogin";
		}
	}
	
	public List<ISAccount> findAll(){
		List<ISAccount> a = iSAccountManager.findAll();
		return a;
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
	
	


}
