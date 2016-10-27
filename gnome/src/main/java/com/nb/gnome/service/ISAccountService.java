package com.nb.gnome.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.ISAccount;
import com.nb.gnome.managers.ISAccountRepository;

import gnome.InitialData;

@Stateless

public class ISAccountService {
	
	@Inject
	private ISAccountRepository iSAccountManager;
	@Inject
	private InitialData initialData;
	
	/**
	 * Method to check that an email address used for an account does/doesn't already exist - CMON TIM!!
	 */
	public boolean accountCheck(String nEmail){
		List <ISAccount> accounts = iSAccountManager.findAll();
		boolean accountValid = false;
		CHECK: for (ISAccount a : accounts){
			if (a.getEmail().equals(nEmail)){
				accountValid = false;
				break CHECK;
			}
			else{
				accountValid = true;
			}
		}
		return accountValid;
	}
	
	
	/**
	 * Calls the ISAccount manager method, pooling params together to create a new account object
	 * */
	public void persistISAccount(String nEmail, String nPassword, String nName){
		ISAccount isaisa = new ISAccount(nEmail, nPassword, nName);
		iSAccountManager.persistISAccount(isaisa);
	}
	
	public List<ISAccount> findAll(){
		List<ISAccount> a = iSAccountManager.findAll();
		return a;
	}
	
	


}
