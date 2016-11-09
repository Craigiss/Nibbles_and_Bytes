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

    
    public String login() throws Exception{
    	String pageReturn = "imsLogin";
    	if(iSAService.logInToIms(email, seasonAndCook(email, password)).equals("successful")){
    		pageReturn="ims/imsIndex?faces-redirect=true";
    		return pageReturn;
    	}else{
    		setError(iSAService.getError());
    	}
     
    	return pageReturn;
    }
    
    public String isUserAdmin(){
    	String page = "imsIndex.xhtml?faces-redirect=true";
    	ISAccount isis = iSAService.findISAccountByEmail(iMSUserCredentials.getEmail());    	
    	if(isis.isAdmin()){
    		page="imsAdmin.xhtml?faces-redirect=true";
    	}
    	return page;    	
    }
    
    public String seasonAndCook(String email, String npassword) throws Exception{
    	String password = iSAService.seasonAndCook(email, npassword);
    	return password;
    }
    
    public String logout(){
    	iMSUserCredentials.resetCredentials();
    	return "../imsLogin?faces-redirect=true";
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
