package com.nb.gnome.mangers.online;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.managers.PurchaseOrderRepository;
import com.nb.gnome.managers.hib.ObjectConverter;

import connection.Connection;
import gnome.InitialData;

@Default
@Stateless
public class PurchaseOrderRepositoryOnline implements PurchaseOrderRepository {
	@Inject
	private Connection connection; 
	@Inject 
	private ObjectConverter converter; 
	
	@Override
	public void persistPurchaseOrder(PurchaseOrder a) {
		connection.persistData(a);
	}
	@Override
	public List<PurchaseOrder> findPurchaseOrder() {
		List<PurchaseOrder> p = converter.ConvertToPurchaseOrder(connection.returnData("PurchaseOrder"));
		
		return p;
	}
	
	@Override
	public PurchaseOrder findPurchaseOrderById(long id) {
		PurchaseOrder po = new PurchaseOrder();
		for(PurchaseOrder p : converter.ConvertToPurchaseOrder(connection.returnData("PurchaseOrder"))){
			if(p.getId() == id){
				po = p;
			}
		}
		return po;	
}
	@Override
	public List<PurchaseOrder> findAll() {
		List<PurchaseOrder> po = converter.ConvertToPurchaseOrder(connection.returnData("PurchaseOrder"));
		return po;
	}
	
	@Override
	public List<PurchaseOrder> findPurchaseOrderBySupplier(Supplier s) {
		List<PurchaseOrder> po = new ArrayList<PurchaseOrder>();
		for(PurchaseOrder p : converter.ConvertToPurchaseOrder(connection.returnData("PurchaseOrder"))){
			if(p.getSupplierid().getId() == s.getId()){
				po.add(p);
			}
		}
		return po;	
	}
}
