package com.nb.gnome.managers;

import java.util.List;

import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.entities.SalesOrderDetails;

/**
 * Interface for SalesOrderDetailsManager classes
 * SalesOrderDetailsManagers will have these methods
 * @author Nibbles and Bytes
 */

public interface SalesOrderDetailsRepository {

	//Create
	public void persistSalesOrderDetails(SalesOrderDetails s);
	
	//Read
	public List<SalesOrderDetails> findSalesOrderDetailsByOrder(SalesOrder so);
	
	public SalesOrderDetails findSalesOrderDetailsById(long id);

	List<SalesOrderDetails> findAll();
	
}
