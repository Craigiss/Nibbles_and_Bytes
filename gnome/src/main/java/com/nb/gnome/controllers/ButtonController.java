package com.nb.gnome.controllers;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.service.ButtonService;
import com.nb.gnome.service.ProductService;


@Named("button")
@SessionScoped
public class ButtonController implements Serializable {
	
	@Inject
	private ButtonService buttonService;
	private int idOfDeleted;
	
	public String delete(String deleteLocation){
		String returnValue;
		if(idOfDeleted == 0)
		{
			returnValue ="imsProducts";
		}
		else if (deleteLocation.equals("products"))
		{
			returnValue = buttonService.deleteProduct(idOfDeleted);
		}
		else if (deleteLocation.equals("supplier"))
		{
			returnValue = buttonService.deleteSupplier(idOfDeleted);
		}
		else
		{
			returnValue = buttonService.deletePo(idOfDeleted);
		}
		
		return returnValue;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return idOfDeleted;
	}

	/**
	 * @param id the id to set
	 */
	public void passId(int id) {
		idOfDeleted = id;
	}

		
	
	
	

}
