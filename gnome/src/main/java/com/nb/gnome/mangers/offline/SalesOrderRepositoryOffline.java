package com.nb.gnome.mangers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import com.nb.gnome.entities.Customer;
import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.managers.SalesOrderRepository;

import gnome.InitialData;


@Default
@Stateless
public class SalesOrderRepositoryOffline implements SalesOrderRepository  {
	private InitialData initialData; 
	

	@Override
	public void persistSalesOrder(SalesOrder a) {
		initialData.addSalesOrder(a);
	}
	
	@Override
	public ArrayList<SalesOrder> findSalesOrderByCustomerID(int id) {
		ArrayList<SalesOrder> so = new ArrayList<SalesOrder>();
		for(SalesOrder s: initialData.getSalesOrders()){
			if(s.getId() == id){
				so.add(s);
			}
		}
		return so;
	}

	@Override
	public SalesOrder findSalesOrderById(long id) {
		SalesOrder mSales = new SalesOrder();
		for(SalesOrder p : initialData.getSalesOrders()){
			if(p.getId() == id){
				mSales = p;
				break;
			}
		}
		return mSales; 
	}

	@Override
	public List<SalesOrder> findAll() {
		return initialData.getSalesOrders();
	}

}
