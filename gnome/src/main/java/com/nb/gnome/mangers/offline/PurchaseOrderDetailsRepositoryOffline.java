package com.nb.gnome.mangers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.PurchaseOrderDetails;
import com.nb.gnome.managers.PurchaseOrderDetailsRepository;

import gnome.InitialData;
@Default
@Stateless
public class PurchaseOrderDetailsRepositoryOffline implements PurchaseOrderDetailsRepository{

	@Inject
	private InitialData initialData;
	
	@Override
	public void persistPOD(PurchaseOrderDetails pod) {
		initialData.addPurchaseOrderDetails(pod);
	}

}
