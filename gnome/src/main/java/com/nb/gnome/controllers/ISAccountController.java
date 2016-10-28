package com.nb.gnome.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.ISAccount;
import com.nb.gnome.service.ISAccountService;

import gnome.InitialData;

@Named("isAccount")
@SessionScoped

public class ISAccountController implements Serializable{
	
	@Inject
	private ISAccountService iSAService;
	@Inject 
	private IMSUserCredentials iMSUserCredentials;
	private String email;
    private String password;
    private String error;

    
    public String login(String nEmail, String nPassword){
    	String pageReturn = "imsLogin";
    	if(iSAService.logInToIms(nEmail, nPassword).equals("successful")){
    		pageReturn="imsIndex";
    	}else{
    		error=iSAService.getError();
    	}
     
    	return pageReturn;
    }
    
    public String logout(){
    	iMSUserCredentials.resetCredentials();
    	return "imsLogin";
    }

	/**
	 * @return the iMSUserCredentials
	 */
	public IMSUserCredentials getIMSUserCredentials() {
		return iMSUserCredentials;
	}

	/**
	 * @param iMSUserCredentials the iMSUserCredentials to set
	 */
	public void setIMSUserCredentials(IMSUserCredentials iMSUserCredentials) {
		this.iMSUserCredentials = iMSUserCredentials;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
