package com.nb.gnome.mangers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.managers.PurchaseOrderRepository;

import gnome.InitialData;

@Default
@Stateless
public class PurchaseOrderRepositoryOffline implements PurchaseOrderRepository {
	@Inject
	private InitialData initialData;
	
	@Override
	public void persistPurchaseOrder(PurchaseOrder a) {
		initialData.addPurchaseOrder(a);
	}
	@Override
	public List<PurchaseOrder> findPurchaseOrder() {
		
		
		return initialData.getPurchaseOrders();
	}
	
	@Override
	public PurchaseOrder findPurchaseOrderById(long id) {
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
		List<PurchaseOrder> po = initialData.getPurchaseOrders();
		return po;
	}
	
	@Override
	public List<PurchaseOrder> findPurchaseOrderBySupplier(Supplier s) {
		List<PurchaseOrder> po = new ArrayList<PurchaseOrder>();
		for(PurchaseOrder p : initialData.getPurchaseOrders()){
			if(p.getSupplierid() == s.getId()){
				po.add(p);
			}
		}
		return po;	
	}
}
