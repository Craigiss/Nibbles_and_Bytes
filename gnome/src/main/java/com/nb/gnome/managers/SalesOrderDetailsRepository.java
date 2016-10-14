package com.nb.gnome.managers;

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
	public SalesOrderDetails findSalesOrderDetails(SalesOrderDetails s);
	
}
