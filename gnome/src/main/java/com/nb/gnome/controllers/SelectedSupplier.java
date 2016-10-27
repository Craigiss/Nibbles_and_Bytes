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
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.helper.PaginationHelper;
import com.nb.gnome.service.PurchaseOrderService;

@Named("selectedSupplier")
@SessionScoped
public class SelectedSupplier implements Serializable {
	private Supplier supplier;
	@Inject
	private PurchaseOrderService purchaseOrderService;
	private PaginationHelper pagination;
	private DataModel<PurchaseOrder> dataModel = null;
	private List<PurchaseOrder> listData;

	/**
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier
	 *            the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public void recreateModel() {
		dataModel = null;
	}

	public String reset() {
		dataModel = null;
		listData = null;
		return "imsSuppliers";
	}

	public PaginationHelper getPagination() {
		if (pagination == null)
			pagination = new PaginationHelper(5) {

				@Override
				public int getItemsCount() {
					if (listData == null) {
						return purchaseOrderService.findAll().size();
					} else {
						return listData.size();
					}
				}

				@Override
				public DataModel<PurchaseOrder> createPageDataModel() {
					// Return products to fill page
					try {
						return new ListDataModel<PurchaseOrder>(
								listData.subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					}
					// Or if there aren't enough, return the rest of them
					catch (Exception e) {
						return new ListDataModel<PurchaseOrder>(listData.subList(getPageFirstItem(), getItemsCount()));
					}
				}
			};

		return pagination;
	}

	public DataModel<PurchaseOrder> getDataModel() {
		if (listData == null) {
			listData = purchaseOrderService.findPurchaseOrderBySupplier(supplier);
		}
		dataModel = getPagination().createPageDataModel();
		return dataModel;

	}

	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "imsSupplierDeets";
	}

	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "imsSupplierDeets";
	}

	/**
	 * @return the listData
	 */
	public List<PurchaseOrder> getListData() {
		return listData;
	}

	/**
	 * @param listData
	 *            the listData to set
	 */
	public void setListData(List<PurchaseOrder> listData) {
		this.listData = listData;
	}

}