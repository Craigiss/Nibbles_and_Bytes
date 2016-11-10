package com.nb.gnome.managers.hib;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.nb.gnome.connection.Connection;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.PurchaseOrderDetails;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.managers.PurchaseOrderRepository;

import gnome.InitialData;

@Alternative
@Stateless
public class PurchaseOrderRepositoryHib implements PurchaseOrderRepository {
	
	@Inject
	private Connection database;
	@Inject
	private ObjectConverter converter;
	
	//private static int PO_COUNTER = 100;
	
	@Override
	public void persistPurchaseOrder(Date mDate, String status, List<PurchaseOrderDetails> mList, Supplier mSup) {
		PurchaseOrder popo = new PurchaseOrder(mDate, status, mList, mSup);
		database.persistData(popo);
		
		for(PurchaseOrderDetails pod : mList){
			pod.setPo(popo);
			database.persistData(pod);
		}
	}
	
	@Override
	public List<PurchaseOrder> findPurchaseOrder() {
		ArrayList<PurchaseOrder> poList = (ArrayList)converter.convertToPO(database.returnData("PurchaseOrder"));
		return poList;
	}
	
	@Override
	public PurchaseOrder findPurchaseOrderById(int id) {
		ArrayList<PurchaseOrder> poList = (ArrayList)converter.convertToPO(database.returnData("PurchaseOrder"));
		PurchaseOrder po = new PurchaseOrder();
		for(PurchaseOrder p : poList){
			if(p.getId() == id){
				po = p;
			}
		}
		return po;	
}
	@Override
	public List<PurchaseOrder> findAll() {
		ArrayList<PurchaseOrder> poList = (ArrayList)converter.convertToPO(database.returnData("PurchaseOrder"));
		List<PurchaseOrder> po = new ArrayList<PurchaseOrder>();
    	for (PurchaseOrder p : poList)
    		if(p.isDeleted() == false)
    		{
    			po.add(p);
    		}
    	return po;
	}
	
	@Override
	public List<PurchaseOrder> findPurchaseOrderBySupplier(Supplier s) {
		ArrayList<PurchaseOrder> poList = (ArrayList)converter.convertToPO(database.returnData("PurchaseOrder"));
		List<PurchaseOrder> po = new ArrayList<PurchaseOrder>();
		for(PurchaseOrder p : poList){
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
		ArrayList<PurchaseOrder> poList = (ArrayList)converter.convertToPO(database.returnData("PurchaseOrder"));
		List<PurchaseOrder> po = new ArrayList<PurchaseOrder>();
		po = poList;
		for(PurchaseOrder p : po){
			if (p.getId() == id){
				p.setDeleted(true);
			}
		}
		
	}
	
}
