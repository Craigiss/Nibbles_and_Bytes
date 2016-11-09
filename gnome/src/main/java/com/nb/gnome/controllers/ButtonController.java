package com.nb.gnome.controllers;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.ISAccount;
import com.nb.gnome.service.ButtonService;
import com.nb.gnome.service.ISAccountService;
import com.nb.gnome.service.ProductService;

@Named("button")
@SessionScoped
public class ButtonController implements Serializable {

	@Inject
	private ISAccountService iSAService;
	@Inject
	private IMSUserCredentials iMSUserCredentials;
	@Inject
	private ButtonService buttonService;
	@Inject
	private PurchaseOrderController poController;
	private int idOfProduct;

	public String delete(String deleteLocation) {
		String returnValue;
		
		if (isUserAdmin()==true) {
			
			if (idOfProduct == 0) {
				returnValue = "imsProducts";
			} else if (deleteLocation.equals("products")) {
				returnValue = buttonService.deleteProduct(idOfProduct);
			} else if (deleteLocation.equals("suppliers")) {
				returnValue = buttonService.deleteSupplier(idOfProduct);
			} else {
				returnValue = buttonService.deletePo(idOfProduct);
			}
		}else{
			if (deleteLocation.equals("products")){
				returnValue = "imsProducts";
			}
			else if (deleteLocation.equals("suppliers")){
				returnValue = "imsSuppliers";
			}
			else{
				returnValue = "imsPo";
			}	
		}

		return returnValue + "?faces-redirect=true";
	}
	
	public boolean isUserAdmin(){
    	boolean delete = false;
    	ISAccount isis = iSAService.findISAccountByEmail(iMSUserCredentials.getEmail());    	
    	if(isis.isAdmin()){
    		delete=true;
    	}
    	return delete;    	
    }

	/**
	 * @return the idOfProduct
	 */
	public int getIdOfProduct() {
		return idOfProduct;
	}

	/**
	 * @param idOfProduct
	 *            the idOfProduct to set
	 */
	public void setIdOfProduct(int idOfProduct) {
		this.idOfProduct = idOfProduct;
	}

	public String resetAddPO() {
		return poController.clean();

	}
}
