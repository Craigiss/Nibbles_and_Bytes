package com.nb.gnome.managers;

import java.util.List;

import com.nb.gnome.entities.Customer;
import com.nb.gnome.entities.SalesOrder;

public interface SalesOrderRepository {

	List<SalesOrder> findAll();

	SalesOrder findSalesOrderById(long id);

	List<SalesOrder> findSalesOrderByCustomer(Customer c);

	void persistSalesOrder(SalesOrder a);

}
