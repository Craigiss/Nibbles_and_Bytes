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
	@Inject
	private PurchaseOrderController poController;
	private int idOfProduct;
	
	
	
	public String delete(String deleteLocation){
		String returnValue;
		
		if(idOfProduct == 0)
		{
			returnValue ="imsProducts";
		}
		else if (deleteLocation.equals("products"))
		{
			returnValue = buttonService.deleteProduct(idOfProduct);
		}
		else if (deleteLocation.equals("suppliers"))
		{
			returnValue = buttonService.deleteSupplier(idOfProduct);
		}
		else
		{
			returnValue = buttonService.deletePo(idOfProduct);
		}
		
		return returnValue+"?faces-redirect=true";
	}


	/**
	 * @return the idOfProduct
	 */
	public int getIdOfProduct() {
		return idOfProduct;
	}


	/**
	 * @param idOfProduct the idOfProduct to set
	 */
	public void setIdOfProduct(int idOfProduct) {
		this.idOfProduct = idOfProduct;
	}
	
	public String resetAddPO(){
		return poController.clean();
		
	}
}
