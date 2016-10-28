package com.nb.gnome.controllers;

import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.PurchaseOrderDetails;
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
public class PurchaseOrderController implements Serializable {
	@Inject
	private PurchaseOrderService purchaseOrderService;

	@Inject
	private SelectedPo purchaseOrder;
	private int id;
	private Date date;
	private String status;
	private Supplier supplier;
	private List<PurchaseOrderDetails> lines;
	private PaginationHelper pagination;
	private DataModel<PurchaseOrder> dataModel = null;
	private List<PurchaseOrder> listData;

	private void recreateModel() {
		dataModel = null;
	}

	public String reset() {
		dataModel = null;
		listData = null;
		return "imsIndex";

	}

	public PaginationHelper getPagination() {
		if (pagination == null)
			pagination = new PaginationHelper(2) {
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
			listData = purchaseOrderService.findAll();
		}
		dataModel = getPagination().createPageDataModel();
		return dataModel;

	}

	public void setData(ArrayList<PurchaseOrder> model) {
		listData = model;
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
	 * 
	 * @param id
	 * @return
	 */
	public PurchaseOrder findPurchaseOrderById(String id) {
		return purchaseOrderService.findPoById(id);
	}

	/**
	 * Retrieve all purchase orders on the system
	 * 
	 * @return
	 */
	public List<PurchaseOrder> findAll() {
		return purchaseOrderService.findAll();
	}

	public String view(PurchaseOrder p) {
		purchaseOrder.setPurchaseOrder(p);
		return "imsPoDeets";
	}

	public int findLines(PurchaseOrder purchaseOrder) {
		return purchaseOrderService.findItemsQuantity(purchaseOrder);
	}

	public String calculateTotal(PurchaseOrder p) {
		return purchaseOrderService.calculateTotal(p);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

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

	/**
	 * @return the lines
	 */
	public List<PurchaseOrderDetails> getLines() {
		return lines;
	}

	/**
	 * @param lines
	 *            the lines to set
	 */
	public void setLines(List<PurchaseOrderDetails> lines) {
		this.lines = lines;
	}

	/**
	 * @param purchaseOrder
	 *            the purchaseOrder to set
	 */
	public void setPurchaseOrder(SelectedPo purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	/**
	 * @param pagination
	 *            the pagination to set
	 */
	public void setPagination(PaginationHelper pagination) {
		this.pagination = pagination;
	}

	public List<PurchaseOrder> findPurchaseOrderBySupplier(Supplier s) {
		return purchaseOrderService.findPurchaseOrderBySupplier(s);
	}

	public String persistPurchaseOrder() {
		purchaseOrderService.persistPurchaseOrder(id, date, status, lines);
		recreateModel();

		id = 0;
		date = null;
		status = "";
		lines = null;

		listData = null;

		return "imsPo";
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
