package com.nb.gnome.mangers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.entities.SalesOrderDetails;
import com.nb.gnome.managers.SalesOrderDetailsRepository;

import gnome.InitialData;
@Default
@Stateless
public class SalesOrderDetailsRepositoryOffline implements SalesOrderDetailsRepository {

	@Inject
	private InitialData initialData;

	//Create
	@Override
	public void persistSalesOrderDetails(SalesOrderDetails s){
		initialData.addSalesOrderDetails(s);
	}

	//Read
	public SalesOrderDetails findSalesOrderDetailsById(long id) {
		SalesOrderDetails sod = new SalesOrderDetails();
		for(SalesOrderDetails deets : initialData.getSalesOrdersDetails()){
			if(deets.getId() == id){
				sod = deets;
				break;
			}
		}
		return sod;
	}

	@Override
	public List<SalesOrderDetails> findSalesOrderDetailsByOrder(SalesOrder so) {
		List<SalesOrderDetails> newOne = new ArrayList<SalesOrderDetails>();
		for(SalesOrderDetails deets : initialData.getSalesOrdersDetails()){
			if (deets.getFKSalesOrderId() == deets.getFKSalesOrderId()){
				newOne.add(deets);
			}
		}
		return newOne;
	}
	
	@Override
	public List<SalesOrderDetails> findAll() {
		return initialData.getSalesOrdersDetails();
	}

	
}

