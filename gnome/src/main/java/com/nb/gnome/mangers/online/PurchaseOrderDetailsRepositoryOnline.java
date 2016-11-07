package com.nb.gnome.mangers.online;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.PurchaseOrderDetails;
import com.nb.gnome.managers.PurchaseOrderDetailsRepository;
import com.nb.gnome.managers.hib.ObjectConverter;

import connection.Connection;
import gnome.InitialData;
@Default
@Stateless
public class PurchaseOrderDetailsRepositoryOnline implements PurchaseOrderDetailsRepository{

	@Inject
	private Connection connection;
	@Inject 
	private ObjectConverter converter; 
	
	@Override
	public void persistPOD(PurchaseOrderDetails pod) {
		connection.persistData(pod);
	}

	@Override
	public List<PurchaseOrderDetails> getPurchaseOrderDetails(PurchaseOrder po) {
		ArrayList<PurchaseOrderDetails> list = new ArrayList<PurchaseOrderDetails>();
		
		for(PurchaseOrderDetails p : converter.ConvertToPurchaseOrderDetails(connection.returnData("PurchaseOrderDetails"))){
			if(p.getPurchaseOrder().getId() == po.getId()){
				list.add(p);
			}
		}
		return list;
	}

}
