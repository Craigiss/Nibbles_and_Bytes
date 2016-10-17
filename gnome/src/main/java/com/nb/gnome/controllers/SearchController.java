//Kieran Working On
package com.nb.gnome.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.service.SearchService;

@Named("search")
@RequestScoped
public class SearchController{
	
	private String term;
	@Inject private SearchService searchServ;
	@Inject private SelectedProduct selectedProd;
	
	
	public String searchProd(){
		return "";
	}
	
	
	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * @param term the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	
	

}
