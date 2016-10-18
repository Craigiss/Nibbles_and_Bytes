package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;

import com.nb.gnome.entities.Supplier;
import com.nb.gnome.helper.PaginationHelper;
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
	private SupplierService supplierService;
	private Supplier supplier;
	private PaginationHelper pagination;
	private DataModel<Supplier> dataModel = null;

	private void recreateModel() {
		dataModel = null;
	}
	
	public PaginationHelper getPagination() {
		if (pagination == null)	
			pagination = new PaginationHelper(10){
		@Override 
		public int getItemsCount() {
			return supplierService.findAll().size();
		}
	
		@Override public DataModel<Supplier>createPageDataModel(){
			try{
				return new ListDataModel<Supplier>(supplierService.findAll().subList(getPageFirstItem(),getPageFirstItem() + getPageSize()));
			} catch (Exception e) { return new ListDataModel<Supplier>(supplierService.findAll().subList(getPageFirstItem(),getItemsCount()));
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
		supplier = supplierService.findSupplierById(id);
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
	 */
	public String persistSupplier(){
		System.out.println("<><><><><><><><><><><><><><><><><><><><><><>supplier company at beginning of persist supplier = " + supplier.getCompany());
		Supplier lastId = new Supplier();
		lastId.setId(0);
		ArrayList<Supplier> sups=(ArrayList<Supplier>) supplierService.findAll();
		for(Supplier sup:sups){
			if (sup.getId()>lastId.getId()){
				lastId=sup;
				System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><> inside sup/lastid for/if loop last.getid = " + lastId.getId());
			}
		}
		System.out.println("<><><><><><><><><><><><><><><><><><><><><><>lastId.getId() = " + lastId.getId());
		supplier.setId(lastId.getId()+1);
		supplierService.persistSupplier(supplier);
		recreateModel();
		
		//Remove this afterwards
		//
		for(Supplier s: supplierService.findAll()){
			System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><>" + s.getCompany());
		}
		
		return "imsSuppliers";
	}
	
	/**
	 *  finds a supplier by a given company name
	 * @param comp
	 */
	public void findSupplierByCompany(String comp){
		supplierService.findSupplierByCompany(comp);
	}	
	}

