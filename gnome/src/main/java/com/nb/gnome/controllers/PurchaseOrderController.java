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
import com.nb.gnome.service.PurchaseOrderService;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
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
	IMSUserCredentials userCredentials;

	@Inject
	private SelectedPo purchaseOrder;
	
	@Inject
	private PurchaseOrderDetailsController podController;

	private Supplier supplier;
	private List<PurchaseOrderDetails> lines;
	private PaginationHelper pagination;
	private DataModel<PurchaseOrder> dataModel = null;
	private List<PurchaseOrder> listData;
	private List<Product> listProducts;
	
	public String persistPurchaseOrder() {
		// Set the current date and status
		Date theDate = new Date();
		
		// Retrieve purchase order details
		lines = podController.getListPOD();
		
		// Run persist method
		String status = "Awaiting Approval";
		
		purchaseOrderService.persistPurchaseOrder(theDate, status, lines, supplier);

		// Reset fields		
		return clean();
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
		String returnPage = "imsPoDeets?faces-redirect=true";
		if (!(userCredentials.getName() == null)) {
			purchaseOrder.setPurchaseOrder(p);

		} else {
			returnPage = "imsLogin?faces-redirect=true";
		}
		return returnPage;
	}

	public int findLines(PurchaseOrder purchaseOrder) {
		return purchaseOrderService.findItemsQuantity(purchaseOrder);
	}

	public String calculateTotal(PurchaseOrder p) {
		return purchaseOrderService.calculateTotal(p);
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
	 * @return the listProducts
	 */
	public List<Product> getListProducts() {
		return listProducts;
	}

	/**
	 * @param listProducts
	 *            the listProducts to set
	 */
	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}
	
	/**
	 * @return the podController
	 */
	public PurchaseOrderDetailsController getPodController() {
		return podController;
	}

	/**
	 * @param podController the podController to set
	 */
	public void setPodController(PurchaseOrderDetailsController podController) {
		this.podController = podController;
	}

	public void supplierChangeListener(ValueChangeEvent event) {
		listProducts = new ArrayList<Product>();
		if (event.getNewValue() != null) {
			Supplier sup = (Supplier) event.getNewValue();
			if (sup.getProducts() != null){
				listProducts = sup.getProducts();
			}
		}
	}
	
	public String clean(){
		supplier = null;
		lines = null;
		listProducts = null;
		podController.clean();
		return "imsPo?faces-redirect=true";
	}
	

	//
	// PAGINATION
	// METHODS
	//

	private void recreateModel() {
		dataModel = null;
	}


	public String reset() {
		dataModel = null;
		listData = null;
		return "imsIndex?faces-redirect=true";

	}
	
	public String goToAddPOPage(){
		String returnPage = "addPurchaseOrder";
		if ((userCredentials.getName() == null)) {
			returnPage = "imsLogin?faces-redirect=true";
		}
		return returnPage;
	}

	public PaginationHelper getPagination() {
		if (pagination == null)
			pagination = new PaginationHelper(10) {
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
		return "imsPo?faces-redirect=true";
	}

	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "imsPo?faces-redirect=true";
	}

}

