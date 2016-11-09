package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private PurchaseOrder purchaseOrder;
	@Inject
	private PurchaseOrderService purchaseOrderService;
	private PaginationHelper pagination;
	private DataModel<PurchaseOrderDetails> dataModel = null;
	private List<PurchaseOrderDetails> listData;

	public DataModel<PurchaseOrderDetails> getDataModel() {
		if (listData == null){
			listData = purchaseOrder.getLines();
		}
		return new ListDataModel<PurchaseOrderDetails>(listData);
	}

	/**
	 * @return the purchaseOrder
	 */
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	/**
	 * @param purchaseOrder
	 *            the purchaseOrder to set
	 */
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	/**
	 * @return the listData
	 */
	public List<PurchaseOrderDetails> getListData() {
		return listData;
	}

	/**
	 * @param listData
	 *            the listData to set
	 */
	public void setListData(List<PurchaseOrderDetails> listData) {
		this.listData = listData;
	}
	
	public String reset() {
		dataModel = null;
		listData = null;
		return "imsPo?faces-redirect=true";
	}

}