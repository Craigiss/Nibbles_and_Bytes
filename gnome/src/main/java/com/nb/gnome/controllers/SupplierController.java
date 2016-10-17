package com.nb.gnome.controllers;

import java.io.Serializable;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.helper.PaginationHelper;
import com.nb.gnome.managers.SupplierRepository;
import com.nb.gnome.service.SupplierService;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

@Named("suppliers")
@SessionScoped
public class SupplierController implements Serializable{
	@Inject
	private SupplierRepository supplierRepository;
	private SupplierService supplierService;
	private  Supplier supplier;
	private PaginationHelper pagination;
	private int selected;
	private DataModel<Supplier> dataModel = null;

	private void recreateModel() {
		dataModel = null;
	}
	
	public PaginationHelper getPagination() {
		if (pagination == null)	
			pagination = new PaginationHelper(10){
		@Override 
		public int getItemsCount() {
			return supplierRepository.findAll().size();
		}
	
		@Override public DataModel<Supplier>createPageDataModel(){
			try{
				return new ListDataModel<Supplier>(supplierRepository.findAll().subList(getPageFirstItem(),getPageFirstItem() + getPageSize()));
			} catch (Exception e) { return new ListDataModel<Supplier>(supplierRepository.findAll().subList(getPageFirstItem(),getItemsCount()));
		}
		}
		};
		return pagination;
	}
	
	public DataModel<Supplier> getDataModel() {
		if (dataModel ==null)
			dataModel = getPagination().createPageDataModel();
		return dataModel;
		
	}
	
	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "imsSuppliers";
	}
	
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "imsSuppliers";
	}
	
	public Supplier view(long id) {
		supplier = supplierRepository.findSupplierById(id);
		return supplier;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	/**
	 *  adds a new supplier via various convoluted methods in different classes
	 * @param suup
	 */
	public void persistSupplier(Supplier suup){
		supplierService.persistSupplier(suup);
	}
	}

