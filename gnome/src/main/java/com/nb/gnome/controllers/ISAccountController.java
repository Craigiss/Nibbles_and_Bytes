package com.nb.gnome.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.service.ISAccountService;

@Named("isAccount")
@SessionScoped

public class ISAccountController implements Serializable{
	
	@Inject
	private ISAccountService iSAService;

}
