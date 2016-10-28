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

	public void recreateModel() {
		dataModel = null;
	}

	public String reset() {
		dataModel = null;
		listData = null;
		return "imsPo";
	}

	public PaginationHelper getPagination() {
		if (pagination == null)
			pagination = new PaginationHelper(10) {

				@Override
				public int getItemsCount() {
					return purchaseOrder.getLines().size();
				}

				@Override
				public DataModel<PurchaseOrderDetails> createPageDataModel() {
					// Return products to fill page
					try {
						return new ListDataModel<PurchaseOrderDetails>(
								listData.subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					}
					// Or if there aren't enough, return the rest of them
					catch (Exception e) {
						return new ListDataModel<PurchaseOrderDetails>(
								listData.subList(getPageFirstItem(), getItemsCount()));
					}
				}
			};

		return pagination;
	}

	public DataModel<PurchaseOrderDetails> getDataModel() {
		if (listData == null){
			listData = purchaseOrder.getLines();
		}
		dataModel = getPagination().createPageDataModel();
		return dataModel;

	}

	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "imsPoDeets";
	}

	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "imsPoDeets";
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

}