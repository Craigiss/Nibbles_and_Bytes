package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.richfaces.model.StringChartDataModel;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.service.ProductService;
import com.nb.gnome.service.PurchaseOrderService;
import com.nb.gnome.service.SupplierService;
import com.nb.gnome.entities.Supplier;

import gnome.InitialData;

import org.richfaces.model.ChartDataModel;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.model.DataModel;

@Named("graphs")
@SessionScoped
public class GraphController implements Serializable {

	@Inject
	private ProductService prodServ;
	@Inject
	SupplierService supplierService;
	@Inject
	PurchaseOrderService purchaseOrderService;
	StringChartDataModel pie;
	StringChartDataModel pie2;
	StringChartDataModel pie3;
	List<PurchaseOrder> po;

	private int count;

	@PostConstruct
	public void init() {
		generateCriticalStockLevel();
		generateSupplierPoData();
		generateCriticalPourousStock();

	}

	private void generateCriticalPourousStock() {
		pie3 = new StringChartDataModel(ChartDataModel.ChartType.pie);

		ArrayList<Product> products = (ArrayList<Product>) prodServ.findCriticalStockPourous();
		if (products.size() > 0) {
			for (Product p : products) {
				if (p.isDeleted() == false) {
					pie3.put(p.getProductName() + " " + p.getPorousStockLevel() + " products remaining ", p.getPorousStockLevel());
				}
			}
		} else {
			pie3.put("No Products Critical", 0);
		}

	}
	
	/**
	 * @return the pie3
	 */
	public StringChartDataModel getPie3() {
		return pie3;
	}

	/**
	 * @param pie3 the pie3 to set
	 */
	public void setPie3(String name, int value) {
		pie3.put(name, value);
	}
	
	public void removeSegment3(String name) {
		pie3.remove(name);
	}	
	

	private void generateSupplierPoData() {
		pie2 = new StringChartDataModel(ChartDataModel.ChartType.pie);
		List<Supplier> suppliers = supplierService.findAll();
		for (Supplier s : suppliers) {
			po = purchaseOrderService.findPurchaseOrderBySupplier(s);
			count = po.size();
			pie2.put(s.getCompany() + " Number Purchase Orders " + count, count);
			count = 0;
		}

	}

	/**
	 * @return the supplierService
	 */
	public SupplierService getSupplierService() {
		return supplierService;
	}

	/**
	 * @param supplierService
	 *            the supplierService to set
	 */
	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	/**
	 * @return the purchaseOrderService
	 */
	public PurchaseOrderService getPurchaseOrderService() {
		return purchaseOrderService;
	}

	/**
	 * @param purchaseOrderService
	 *            the purchaseOrderService to set
	 */
	public void setPurchaseOrderService(PurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}

	public void generateCriticalStockLevel() {
		pie = new StringChartDataModel(ChartDataModel.ChartType.pie);

		ArrayList<Product> products = (ArrayList<Product>) prodServ.findCriticalStock();
		if (products.size() > 0) {
			for (Product p : products) {
				if (p.isDeleted() == false) {
					pie.put(p.getProductName() + " " + p.getStockLevel() + " products remaining ", p.getStockLevel());
				}
			}
		} else {
			pie.put("No Products Critical", 0);
		}

	}

	public StringChartDataModel getPie() {
		return pie;
	}

	public void setPie(String name, int value) {
		pie.put(name, value);
	}

	public void removeSegment(String name) {
		pie.remove(name);
	}

	public String reset() {
		return "imsIndex";
	}

	/**
	 * @return the pie2
	 */
	public StringChartDataModel getPie2() {
		return pie2;
	}

	/**
	 * @param pie2
	 *            the pie2 to set
	 */
	public void setPie2(String name, int value) {
		pie2.put(name, value);
	}

	public void removeSegment2(String name) {
		pie2.remove(name);
	}

}
