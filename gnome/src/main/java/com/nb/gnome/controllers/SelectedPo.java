package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.PurchaseOrderDetails;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.helper.PaginationHelper;
import com.nb.gnome.service.PurchaseOrderService;

@Named("selectedPo")
@SessionScoped
public class SelectedPo implements Serializable {
	private PurchaseOrderDetails purchaseOrderDetails;
	private PurchaseOrder purchaseOrder;
	@Inject
	private PurchaseOrderService purchaseOrderService;
	private PaginationHelper pagination;
	private DataModel<PurchaseOrder> dataModel = null;
	
	/**
	 * @return the purchaseOrder
	 */
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	/**
	 * @param purchaseOrder the purchaseOrder to set
	 */
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	/**
	 * @return the purchaseOrderDetails
	 */
	public PurchaseOrderDetails getPurchaseOrderDetails() {
		return purchaseOrderDetails;
	}

	/**
	 * @param purchaseOrderDetails the purchaseOrderDetails to set
	 */
	public void setPurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
	}

	public void recreateModel() {
		dataModel = null;
	}
	
	public String reset(){
		dataModel = null;
		return "imsPo";	
	}
	
	public PaginationHelper getPagination() {
		if (pagination == null)	
			pagination = new PaginationHelper(5){
			
		@Override 
		public int getItemsCount() {
			if (dataModel == null){
				  return purchaseOrderService.findAll().size();
				}
				else {
					return dataModel.getRowCount() + (pagination.getPage() * pagination.getPageSize());
				}
		}
	
		@Override public DataModel<PurchaseOrder>createPageDataModel(){
			try{
				return new ListDataModel<PurchaseOrder>(purchaseOrderService.findAll().subList(getPageFirstItem(),getPageFirstItem() + getPageSize()));
			} catch (Exception e) {
				return new ListDataModel<PurchaseOrder>(
						purchaseOrderService.findAll().subList(getPageFirstItem(),getItemsCount()));
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
	
	public void setData(ArrayList<PurchaseOrder> model ){
		dataModel.setWrappedData(model);
	}
	
	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "browse";
	}
	
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "imsPo";
	}
	

}