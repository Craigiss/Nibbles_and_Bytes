package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named(value="help")
@SessionScoped
public class HelpController implements Serializable{

	public String reset(){
		return "imsIndex";
				
	}
	
	
}

