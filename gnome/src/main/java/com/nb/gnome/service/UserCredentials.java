package com.nb.gnome.service;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("User")
@SessionScoped
public class UserCredentials implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7904470505509637902L;
	private String user = null;
	private String email = null; 
	private int id = 0;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

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
