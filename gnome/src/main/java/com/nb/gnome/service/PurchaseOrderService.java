package com.nb.gnome.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.PurchaseOrderDetails;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.managers.PurchaseOrderRepository;

import gnome.InitialData;

@Stateless
public class PurchaseOrderService {

	@Inject
	private PurchaseOrderRepository purchaseOrderManager;
	
	public PurchaseOrder findPoById(String id){
		
		try{
			int searchId = Integer.parseInt(id);
			return purchaseOrderManager.findPurchaseOrderById(searchId);
		}
		catch( Exception e){
			return null;
		}	
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
		return "�" + pounds + "." + String.format("%02d", pence);
	}
	
	public List<PurchaseOrder> findPurchaseOrderBySupplier(Supplier s){
		return purchaseOrderManager.findPurchaseOrderBySupplier(s);
	}
	
}
