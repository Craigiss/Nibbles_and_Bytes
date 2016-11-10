package com.nb.gnome.managers;

import java.util.ArrayList;
import java.util.List;

import com.nb.gnome.entities.Customer;
import com.nb.gnome.entities.SalesOrder;

public interface SalesOrderRepository {

	List<SalesOrder> findAll();

	SalesOrder findSalesOrderById(int id);

	//ArrayList<SalesOrder> findSalesOrderByCustomerID(int id);

	void persistSalesOrder(SalesOrder a);

	ArrayList<SalesOrder> findSalesOrderByCustomer(Customer c);

	void updateOrder(SalesOrder a);
}
