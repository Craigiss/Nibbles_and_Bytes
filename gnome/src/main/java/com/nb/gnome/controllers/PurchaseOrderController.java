package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.List;

import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.helper.PaginationHelper;
import com.nb.gnome.managers.PurchaseOrderRepository;
import com.nb.gnome.service.PurchaseOrderService;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

@Named("pos")
@SessionScoped
public class PurchaseOrderController implements Serializable{
	@Inject
	private PurchaseOrderService purchaseOrderService;
	
	@Inject
	private SelectedPurchaseOrder purchaseOrder;
	private PurchaseOrder nPurchaseOrder;
	private PaginationHelper pagination;
	private DataModel<PurchaseOrder> dataModel = null;

	private void recreateModel() {
		dataModel = null;
	}
	
	public PaginationHelper getPagination() {
		if (pagination == null)	pagination = new PaginationHelper(10){
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
			} catch (Exception e) { return new ListDataModel<PurchaseOrder>(purchaseOrderService.findAll().subList(getPageFirstItem(),getItemsCount()));
		}
		}
		};
		return pagination;
	}
	
	public String reset(){
		dataModel = null;
		return "imsIndex";
				
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
	
	/**
	 * Find Purchase Order by ID
	 * @param id
	 * @return
	 */
	public PurchaseOrder findPurchaseOrderById(long id) {
		return purchaseOrderService.findPurchaseOrderById(id);
	}
	
	/**
	 * Retrieve all purchase orders on the system
	 * @return
	 */
	public List<PurchaseOrder> findAll(){
		return purchaseOrderService.findAll();
	}
	
	public String view(PurchaseOrder p) {
		purchaseOrder.setPurchaseOrder(p);
		return "imsPoDeets";
	}
	
	public PurchaseOrder getPurchaseOrder() {
		return nPurchaseOrder;
	}
	
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.nPurchaseOrder = purchaseOrder;
	}
	
	public int findLines(PurchaseOrder p){
		return purchaseOrderService.findItemsQuantity(p);
	}
	
	public String calculateTotal(PurchaseOrder p){
		return purchaseOrderService.calculateTotal(p);
	}
	
	
	
	}

