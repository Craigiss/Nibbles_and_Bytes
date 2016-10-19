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

@Named(value="suppliers")
@SessionScoped
public class SupplierController implements Serializable{
	@Inject
	private SupplierService supplierService;
	
	private Supplier supplier;
	private String company;
	private String name;
	private String email;
	private String phone;
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
//		Supplier lastId = new Supplier();
//		lastId.setId(0);
//		
//		ArrayList<Supplier> sups=(ArrayList<Supplier>) supplierService.findAll();
//		for(Supplier sup:sups){
//			if (sup.getId()>lastId.getId()){
//				lastId=sup;
//			}
//		}

		
		supplierService.persistSupplier(company, name, phone, email);
		recreateModel();
		
		return "imsSuppliers";
	}
	

	/**
	 *  finds a supplier by a given company name
	 * @param comp
	 */
	public void findSupplierByCompany(String comp){
		supplierService.findSupplierByCompany(comp);
	}

	/**
	 * @return the supplierService
	 */
	public SupplierService getSupplierService() {
		return supplierService;
	}

	/**
	 * @param supplierService the supplierService to set
	 */
	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @param pagination the pagination to set
	 */
	public void setPagination(PaginationHelper pagination) {
		this.pagination = pagination;
	}

	/**
	 * @param dataModel the dataModel to set
	 */
	public void setDataModel(DataModel<Supplier> dataModel) {
		this.dataModel = dataModel;
	}	
	
	
	
	
	
	}

