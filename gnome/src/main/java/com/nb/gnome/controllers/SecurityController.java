package com.nb.gnome.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Named;

@Named(value = "security")
@SessionScoped
public class SecurityController implements Serializable {

	public void checkPermissions(ComponentSystemEvent event){
		
	}
	
}
