package com.nb.gnome.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.PurchaseOrderDetails;
import com.nb.gnome.managers.PurchaseOrderRepository;

@Stateless
public class PurchaseOrderService {

	@Inject
	private PurchaseOrderRepository purchaseOrderManager;
	

	/**
	 * Returns purchase order with id matching the parameter
	 * @param id
	 * @return Purchase Order with ID matching parameter
	 */
	public PurchaseOrder findPurchaseOrderById(long id){
		return purchaseOrderManager.findPurchaseOrderById(id);
	}
	
	/**
	 * Calls sister method parsing String input as long
	 * @param id
	 * @return Purchase Order with ID matching parameter
	 */
	public PurchaseOrder findPurchaseOrderById(String id){
		return findPurchaseOrderById(Long.parseLong(id));
	}
	
	/**
	 * Calls method within purchaseOrderManager to return all Purchase Orders
	 * @return
	 */
	public List<PurchaseOrder> findAll(){
		return purchaseOrderManager.findAll();
	}

	public int findItemsQuantity(PurchaseOrder p){
		return purchaseOrderManager.findItemsQuantity(p);
	}
	
	public String calculateTotal(PurchaseOrder p){
		int pounds = 0;
		int pence = 0;
		for(PurchaseOrderDetails d : purchaseOrderManager.getOrderLines(p)){
			pounds += (int) (d.getProduct().getPrice()*d.getQuantity() / 1);
			pence += (int) ((d.getProduct().getPrice()*d.getQuantity()) * 100) % 100;
			if(pence >= 100){
				pounds++;
				pence -= 100;
			}
		}
		return "£" + pounds + "." + String.format("%02d", pence);
	}
	
}
