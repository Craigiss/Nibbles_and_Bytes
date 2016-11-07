package com.nb.gnome.managers;

import java.util.Date;
import java.util.List;

import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.PurchaseOrderDetails;
import com.nb.gnome.entities.Supplier;

/**
 * Interface for PurchaseOrderManager classes
 * PurchaseOrderManagers will have these methods
 * @author Nibbles and Bytes
 */

public interface PurchaseOrderRepository {
		//Create
		public void persistPurchaseOrder(int mId, Date mDate, String mStatus, List<PurchaseOrderDetails> mList, Supplier mSup);
		//Read
		public List<PurchaseOrder> findPurchaseOrder();
		
		public PurchaseOrder findPurchaseOrderById(int id);
		
		public List<PurchaseOrder> findPurchaseOrderBySupplier(Supplier s);
		
		public List<PurchaseOrder> findAll();
		
		public int findItemsQuantity(PurchaseOrder p);
		
		public void deletePurchaseOrder(int id);
}
