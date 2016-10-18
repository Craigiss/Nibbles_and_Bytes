package com.nb.gnome.service;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("User")
@SessionScoped
public class UserCredentials implements Serializable {
	
	private String user = null;
	private String email = null; 
	
	public String getUser(){
		return user;
	}
	
	public void setUser (String user){
		this.user = user;
	}
	
	public void setEmail (String email){
		this.email = email; 
	}
	
	public String getEmail(){
		return email;
	}
}
