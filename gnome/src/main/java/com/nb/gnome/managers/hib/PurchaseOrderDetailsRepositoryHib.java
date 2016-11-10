package com.nb.gnome.managers.hib;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.nb.gnome.connection.Connection;
import com.nb.gnome.entities.PurchaseOrderDetails;
import com.nb.gnome.managers.PurchaseOrderDetailsRepository;


@Alternative
@Stateless
public class PurchaseOrderDetailsRepositoryHib implements PurchaseOrderDetailsRepository{

	@Inject
	private Connection database;
	
	@Override
	public void persistPOD(PurchaseOrderDetails pod) {
		database.persistData(pod);
	}

}
