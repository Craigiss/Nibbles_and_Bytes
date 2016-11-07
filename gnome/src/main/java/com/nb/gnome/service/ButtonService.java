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
import com.nb.gnome.managers.ProductRepository;
import com.nb.gnome.managers.PurchaseOrderRepository;
import com.nb.gnome.managers.SupplierRepository;

import gnome.InitialData;

@Stateless
public class ButtonService {
	@Inject private InitialData initialData; 
	
	@Inject private ProductRepository productRepro;
	@Inject private SupplierRepository supplierRepro;
	@Inject private PurchaseOrderRepository poRepro;
	
	@Inject private ProductController prodController;
	@Inject private SupplierController supplierController;
	@Inject private PurchaseOrderController poController;
	
	@Inject private GraphController graph;
		
	public String deleteProduct(int id){
		productRepro.deleteProduct(id);
		prodController.reset();
		return "imsProducts";
	}
	
	public String deleteSupplier(int id){
		supplierRepro.deleteSupplier(id);
		supplierController.reset();
		return "imsSupplier";
	}
	
	public String deletePo(int id){	
		poRepro.deletePurchaseOrder(id);
		poController.reset();
		return "imsPo";
	}

}
