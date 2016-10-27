package com.nb.gnome.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.controllers.GraphController;
import com.nb.gnome.controllers.ProductController;
import com.nb.gnome.controllers.PurchaseOrderController;
import com.nb.gnome.controllers.SupplierController;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.Supplier;


import gnome.InitialData;

@Stateless
public class ButtonService {
	@Inject private InitialData initialData; 
	@Inject private ProductController prodController;
	@Inject private SupplierController supplierController;
	@Inject private PurchaseOrderController poController;
	@Inject private GraphController graph;
		
	public String deleteProduct(int id){
		for(Product p : initialData.getProducts())
		{
			if (p.getProductID() == id)
			{
				p.setDeleted(true);
				graph.removeSegment(p.getProductName());
			}
		}
		prodController.reset();
		return "imsProducts";
	}
	
	public String deleteSupplier(int id){
		List<Supplier> suppliers = new ArrayList<Supplier>();
		suppliers = initialData.getSuppliers();
		for(Supplier s : suppliers)
		{
			if (s.getId() == id)
			{
				s.setDeleted(true);
			}
		}
		
		supplierController.reset();
		return "imsSupplier";
	}
	
	public String deletePo(int id){	
		List<PurchaseOrder> po = new ArrayList<PurchaseOrder>();
		po = initialData.getPurchaseOrders();
		for(PurchaseOrder p : po){
			if (p.getId() == id){
				p.setDeleted(true);
			}
		}
		
		poController.reset();
		return "imsPo";
	}

}
