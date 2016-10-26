package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;

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
		return "imsSuppliers";
	}

	public PaginationHelper getPagination() {
		if (pagination == null)
			pagination = new PaginationHelper(5) {

				@Override
				public int getItemsCount() {
					if (dataModel == null) {
						return purchaseOrderService.findPurchaseOrderBySupplier(supplier).size();
					} else {
						return dataModel.getRowCount() + (pagination.getPage() * pagination.getPageSize());
					}
				}

				@Override
				public DataModel<PurchaseOrder> createPageDataModel() {
					try {
						return new ListDataModel<PurchaseOrder>(
								purchaseOrderService.findPurchaseOrderBySupplier(supplier).subList(getPageFirstItem(),
										getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<PurchaseOrder>(purchaseOrderService
								.findPurchaseOrderBySupplier(supplier).subList(getPageFirstItem(), getItemsCount()));
					}
				}
			};
		return pagination;
	}

	public DataModel<PurchaseOrder> getDataModel() {
		if (dataModel == null)
			dataModel = getPagination().createPageDataModel();
		return dataModel;

	}

	public void setData(ArrayList<PurchaseOrder> model) {
		dataModel.setWrappedData(model);
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

}