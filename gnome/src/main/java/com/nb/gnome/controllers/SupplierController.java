package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.helper.PaginationHelper;
import com.nb.gnome.service.SupplierService;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "suppliers")
@SessionScoped
public class SupplierController implements Serializable {
	@Inject
	private SupplierService supplierService;
	@Inject
	private IMSUserCredentials userCredentials;
	@Inject
	private AddressController addressController;
	@Inject
	private SelectedSupplier supplier;
	private String company;
	private String name;
	private String email;
	private String phone;
	private String description;
	private PaginationHelper pagination;
	private DataModel<Supplier> dataModel = null;
	private List<Supplier> listData;
	private Address address;

	public void recreateModel() {
		dataModel = null;
	}

	public String reset() {
		dataModel = null;
		listData = null;
		return "imsIndex?faces-redirect=true";

	}
	
	public String goToAddSupplier(){
		String returnPage = "addSupplier?faces-redirect=true";
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
					return supplierService.findAll().size();
				} else {
					return listData.size();
				}
			}

				@Override
				public DataModel<Supplier> createPageDataModel() {
					// Return products to fill page
					try {
						return new ListDataModel<Supplier>(
								listData.subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					}
					// Or if there aren't enough, return the rest of them
					catch (Exception e) {
						return new ListDataModel<Supplier>(listData.subList(getPageFirstItem(), getItemsCount()));
					}
				}
			};

		return pagination;
	}

	public DataModel<Supplier> getDataModel() {
		if (listData == null) {
			listData = supplierService.findAll();
		}
		dataModel = getPagination().createPageDataModel();
		return dataModel;

	}

	public void setData(ArrayList<Supplier> model) {
		listData = model;
	}

	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "imsSuppliers?faces-redirect=true";
	}

	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "imsSuppliers?faces-redirect=true";
	}

	public String view(Supplier s) {
		String returnPage = "imsSupplierDeets?faces-redirect=true";
		if (!(userCredentials.getName() == null)) {
		supplier.setSupplier(s);
		}else {
			returnPage = "imsLogin?faces-redirect=true";
		}		
		return returnPage;
	}

	public List<Supplier> findAll() {
		return supplierService.findAll();
	}
	

	/**
	 * adds a new supplier via various convoluted methods in different classes
	 */

	public String persistSupplier() {
		address = addressController.persistAddress();
		addressController.clean();
		supplierService.persistSupplier(company, name, phone, email, description, address);
		//address = addressController.persistAddress();
		recreateModel();
		getDataModel();

		company = "";
		name = "";
		phone = "";
		email = "";
		description = "";
		
		reset();

		return "imsSuppliers?faces-redirect=true";
	}

	/**
	 * finds a supplier by a given company name
	 * 
	 * @param comp
	 */
	public List<Supplier> findSupplierByCompany(String comp) {
		return supplierService.findSupplierByCompany(comp);
	}

	/**
	 * @return the supplierService
	 */
	public SupplierService getSupplierService() {
		return supplierService;
	}

	/**
	 * @param supplierService
	 *            the supplierService to set
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
	 * @param company
	 *            the company to set
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
	 * @param name
	 *            the name to set
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
	 * @param email
	 *            the email to set
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
	 * @param phone
	 *            the phone to set (these auto-generated comments are lol)
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param pagination
	 *            the pagination to set
	 */
	public void setPagination(PaginationHelper pagination) {
		this.pagination = pagination;
	}

	/**
	 * @param dataModel
	 *            the dataModel to set
	 */
	public void setDataModel(DataModel<Supplier> dataModel) {
		this.dataModel = dataModel;
	}

	/**
	 * @return the listData
	 */
	public List<Supplier> getListData() {
		return listData;
	}

	/**
	 * @param listData
	 *            the listData to set
	 */
	public void setListData(List<Supplier> listData) {
		this.listData = listData;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
