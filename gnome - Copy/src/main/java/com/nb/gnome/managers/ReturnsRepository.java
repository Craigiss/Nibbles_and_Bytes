package com.nb.gnome.managers;

import java.util.List;

import com.nb.gnome.entities.Returns;

/**
 * Interface for Returns Manager classes relating to the customer returns
 * Returns Managers will have these methods
 * @author Nibbles and Bytes
 */

public interface ReturnsRepository {
	
	//Create
	public void persistReturns(Returns r);
	
	//Read
	public List<Returns> findReturnsBySalesOrder(long id);

}
