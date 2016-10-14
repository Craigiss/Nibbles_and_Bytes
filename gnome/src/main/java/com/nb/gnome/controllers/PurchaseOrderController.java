package com.nb.gnome.controllers;

import java.io.Serializable;
import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.helper.PaginationHelper;
import com.nb.gnome.managers.PurchaseOrderRepository;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

@Named("pos")
@SessionScoped
public class PurchaseOrderController implements Serializable{
	@Inject
	private PurchaseOrderRepository purchaseOrderRepository;
	private PurchaseOrder purchaseOrder;
	private PaginationHelper pagination;
	private int selected;
	private DataModel<PurchaseOrder> dataModel = null;

	private void recreateModel() {
		dataModel = null;
	}
	
	public PaginationHelper getPagination() {
		if (pagination == null)	pagination = new PaginationHelper(10){
		@Override public int getItemsCount() {
			return purchaseOrderRepository.findAll().size();
		}
	
		@Override public DataModel<PurchaseOrder>createPageDataModel(){
			try{
				return new ListDataModel<PurchaseOrder>(purchaseOrderRepository.findAll().subList(getPageFirstItem(),getPageFirstItem() + getPageSize()));
			} catch (Exception e) { return new ListDataModel<PurchaseOrder>(purchaseOrderRepository.findAll().subList(getPageFirstItem(),getItemsCount()));
		}
		}
		};
		return pagination;
	}
	
	public DataModel<PurchaseOrder> getDataModel() {
		if (dataModel ==null)
			dataModel = getPagination().createPageDataModel();
		return dataModel;
		
	}
	
	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "imsPo";
	}
	
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "imsPo";
	}
	
	public PurchaseOrder view(long id) {
		purchaseOrder = purchaseOrderRepository.findPurchaseOrderById(id);
		return purchaseOrder;
	}
	
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
	
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}	
	}

