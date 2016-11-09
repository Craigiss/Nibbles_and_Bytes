package com.nb.gnome.mangers.online;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.entities.SalesOrderDetails;
import com.nb.gnome.managers.SalesOrderDetailsRepository;
import com.nb.gnome.managers.hib.ObjectConverter;

import connection.Connection;

@Alternative
@Stateless
public class SalesOrderDetailsRepositoryOnline implements SalesOrderDetailsRepository {

	@Inject
	private Connection connection;

	@Inject
	private ObjectConverter converter;
	
	//Create
	@Override
	public void persistSalesOrderDetails(SalesOrderDetails s){
		connection.persistData(s);
	}

	//Read
	public SalesOrderDetails findSalesOrderDetailsById(long id) {
		SalesOrderDetails sod = new SalesOrderDetails();
		for(SalesOrderDetails deets : converter.convertToSalesOrderDetails(connection.returnData("SalesOrderDetails"))){
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
		for(SalesOrderDetails deets : converter.convertToSalesOrderDetails(connection.returnData("SalesOrderDetails"))){
			if (deets.getFKSalesOrderId() == deets.getFKSalesOrderId()){
				newOne.add(deets);
			}
		}
		return newOne;
	}
	
	@Override
	public List<SalesOrderDetails> findAll() {
		return converter.convertToSalesOrderDetails(connection.returnData("SalesOrderDetails"));
	}

	
}

