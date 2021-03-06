package com.nb.gnome.managers;

import java.util.List;

import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.Supplier;

/**
 * Interface for PurchaseOrderManager classes
 * PurchaseOrderManagers will have these methods
 * @author Nibbles and Bytes
 */

public interface PurchaseOrderRepository {
		//Create
		public void persistPurchaseOrder(PurchaseOrder a);
		//Read
		public List<PurchaseOrder> findPurchaseOrder();
		
		public PurchaseOrder findPurchaseOrderById(long id);
		
		public List<PurchaseOrder> findPurchaseOrderBySupplier(Supplier s);
		
		public List<PurchaseOrder> findAll();
}
