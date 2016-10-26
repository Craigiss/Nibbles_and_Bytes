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
	
	
	
	public String delete(int id ,String deleteLocation){
		String returnValue;
		
		if(id == 0)
		{
			returnValue ="imsProducts";
		}
		else if (deleteLocation.equals("products"))
		{
			returnValue = buttonService.deleteProduct(id);
		}
		else if (deleteLocation.equals("suppliers"))
		{
			returnValue = buttonService.deleteSupplier(id);
		}
		else
		{
			returnValue = buttonService.deletePo(id);
		}
		
		return returnValue;
	}
}
