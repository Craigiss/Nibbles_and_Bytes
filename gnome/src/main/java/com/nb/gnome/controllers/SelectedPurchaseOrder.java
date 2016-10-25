package com.nb.gnome.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.nb.gnome.entities.PurchaseOrder;

@Named("selectedPO")
@SessionScoped
public class SelectedPurchaseOrder implements Serializable {
	private PurchaseOrder purchaseOrder;

	/**
	 * @return the purchaseOrder
	 */
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	/**
	 * @param purchaseOrder the purchaseOrder to set
	 */
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	

}
