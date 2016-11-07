package com.nb.gnome.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("IMSUser")
@SessionScoped
public class IMSUserCredentials implements Serializable {
    
    private String email = null;
    private String name = null;
    private String role = null;
    

    public String getEmail(){
        return email;
    }
    
    public void setEmail (String email){
        this.email = email;
    }
    
    public void setName (String name){
        this.name = name; 
    }
    
    public String getName(){
        return name;
    }
    
    public void resetCredentials(){
    	email=null;
    	name=null;
    }

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	
    
        
}