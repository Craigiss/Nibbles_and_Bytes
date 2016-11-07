package com.nb.gnome.mangers.online;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Customer;
import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.managers.SalesOrderRepository;
import com.nb.gnome.managers.hib.ObjectConverter;

import connection.Connection;
import gnome.InitialData;


@Default
@Stateless
public class SalesOrderRepositoryOffline implements SalesOrderRepository  {
	@Inject
	private Connection connection;
	@Inject
	private ObjectConverter converter;
	

	@Override
	public void persistSalesOrder(SalesOrder so) {
		connection.persistData(so);
	}
	
	@Override
	public ArrayList<SalesOrder> findSalesOrderByCustomer(Customer c) {
		ArrayList<SalesOrder> so = new ArrayList<SalesOrder>();
		for(SalesOrder s: converter.convertToSalesOrder(connection.returnData("SalesOrder"))){
			if(s.getCustomer() == c){
				so.add(s);
			}
		}
		return so;
	}

	@Override
	public SalesOrder findSalesOrderById(long id) {
		SalesOrder mSales = new SalesOrder();
		for(SalesOrder p : converter.convertToSalesOrder(connection.returnData("SalesOrder"))){
			if(p.getId() == id){
				mSales = p;
				break;
			}
		}
		return mSales; 
	}

	@Override
	public List<SalesOrder> findAll() {
		return converter.convertToSalesOrder(connection.returnData("SalesOrder"));
	}

}
