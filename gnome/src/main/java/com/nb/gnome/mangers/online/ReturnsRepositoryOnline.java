package com.nb.gnome.mangers.online;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Returns;
import com.nb.gnome.managers.ReturnsRepository;

import gnome.InitialData;
@Alternative
@Stateless
public class ReturnsRepositoryOnline implements ReturnsRepository{

	@Inject
	private InitialData initialData;
	
	@Override
	public void persistReturns(Returns r) {
		initialData.addReturn(r);	
	}

	@Override
	public List<Returns> findReturnsBySalesOrder(long id) {
		List<Returns> ret = new ArrayList<Returns>();
		for (Returns r : initialData.getReturns()){
			if (r.getSalesOrderDetails().getFKSalesOrderId() == id)
			{
				ret.add(r);
			}
		}
		return ret;
	}

}
