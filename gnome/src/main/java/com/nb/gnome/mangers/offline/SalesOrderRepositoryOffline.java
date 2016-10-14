package com.nb.gnome.mangers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;


import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.managers.SalesOrderRepository;

import gnome.InitialData;


@Default
@Stateless
public class SalesOrderRepositoryOffline implements SalesOrderRepository  {
	private InitialData initialData; 
	

	public void persistSalesOrder(SalesOrder a) {
		initialData.addSalesOrder(a);
	}
	

	public List<SalesOrder> findSalesOrder() {
		return initialData.getSalesOrders();

	}

	
	public SalesOrder findSalesOrderById(long id) {
		for(SalesOrder p : initialData.getSalesOrders()){
			if(p.getId() == id){
				return p;
			}
		}
		return null; 
	}

	
	public List<SalesOrder> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
