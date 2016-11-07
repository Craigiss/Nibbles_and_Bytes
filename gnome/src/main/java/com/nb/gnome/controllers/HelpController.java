package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named(value="help")
@SessionScoped
public class HelpController implements Serializable{
	
	@Inject
	IMSUserCredentials userCredentials;

	public String reset(){
		return "imsIndex?faces-redirect=true";
				
	}
	
	public String goToAddProductPage(){
		String returnPage = "imsHelp?faces-redirect=true";
		if ((userCredentials.getName() == null)) {
			returnPage = "imsLogin?faces-redirect=true";
		}
		return returnPage;
	}
	
	
	
}

