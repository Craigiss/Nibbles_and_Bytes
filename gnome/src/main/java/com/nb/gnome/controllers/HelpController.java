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
		return "imsIndex";
				
	}
	
	public String goToAddProductPage(){
		String returnPage = "imsHelp";
		if ((userCredentials.getName() == null)) {
			returnPage = "imsLogin";
		}
		return returnPage;
	}
	
	
	
}

