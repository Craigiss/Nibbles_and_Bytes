package com.nb.gnome.managers.offline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.PurchaseOrderDetails;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.managers.PurchaseOrderRepository;

import gnome.InitialData;

@Default
@Stateless
public class PurchaseOrderRepositoryOffline implements PurchaseOrderRepository {
	@Inject
	private InitialData initialData;
	
	@Override
	public void persistPurchaseOrder(int mId, Date mDate, String mStatus, List<PurchaseOrderDetails> mList, Supplier mSup) {
		PurchaseOrder popo = new PurchaseOrder(initialData.getPurchaseOrders().size() + 1, mDate, mStatus, mList, mSup);
		initialData.addPurchaseOrder(popo);
	}
	@Override
	public List<PurchaseOrder> findPurchaseOrder() {
		return initialData.getPurchaseOrders();
	}
	
	@Override
	public PurchaseOrder findPurchaseOrderById(int id) {
		PurchaseOrder po = new PurchaseOrder();
		for(PurchaseOrder p : initialData.getPurchaseOrders()){
			if(p.getId() == id){
				po = p;
			}
		}
		return po;	
}
	@Override
	public List<PurchaseOrder> findAll() {
		List<PurchaseOrder> po = new ArrayList<PurchaseOrder>();
    	for (PurchaseOrder p : initialData.getPurchaseOrders())
    		if(p.isDeleted() == false)
    		{
    			po.add(p);
    		}
    	return po;
	}
	
	@Override
	public List<PurchaseOrder> findPurchaseOrderBySupplier(Supplier s) {
		List<PurchaseOrder> po = new ArrayList<PurchaseOrder>();
		for(PurchaseOrder p : initialData.getPurchaseOrders()){
			if(p.getSupplier().getId() == s.getId()){
				po.add(p);
			}
		}
		return po;	
	}
	
	@Override
	public int findItemsQuantity(PurchaseOrder p){
		return p.getLines().size();
	}
	
	@Override
	public void deletePurchaseOrder(int id) {
		List<PurchaseOrder> po = new ArrayList<PurchaseOrder>();
		po = initialData.getPurchaseOrders();
		for(PurchaseOrder p : po){
			if (p.getId() == id){
				p.setDeleted(true);
			}
		}
		
	}
	
}
